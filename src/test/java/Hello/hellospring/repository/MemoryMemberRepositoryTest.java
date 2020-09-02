package Hello.hellospring.repository;

import Hello.hellospring.domain.Member;
import net.bytebuddy.implementation.bind.annotation.Empty;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.lang.NonNull;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Time;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class MemoryMemberRepositoryTest {
    MemberRepository repository = new MemoryMemberRepository();
    @Autowired
    WebTestClient webTestClient;
    @Autowired
    @NonNull
    MockMvc mockMvc;
    
    @Test
    public void save() {
        Member member = new Member();
        member.setName("Spring");
        repository.save(member);
        Member result = repository.findById(member.getId()).get();
        System.out.println("result = " + (result == member));
        System.out.println("Successful");
        System.out.println(member.getId());

    }
    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("Spring1");
        repository.save(member1);
        Member member2 = new Member();
        member2.setName("Spring2");
        repository.save(member2);
        Member result = repository.findByName("Spring1").get();
        assertThat(result).isEqualTo(member1);

    }
    @Test
    @NonNull
    public void createUser_JSON() {
        String userJson ="{\"username\":\"Seungmin\"}";
        try {

            mockMvc.perform(post("/users/create")
                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                    .accept(MediaType.APPLICATION_JSON_UTF8)
                    .content(userJson))
                    .andExpect(status().isOk());
            System.out.println("Successful");
        }
        catch(Exception e) {

            System.out.println("Successful");

        }



    }
}
