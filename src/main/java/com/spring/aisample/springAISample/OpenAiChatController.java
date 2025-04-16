package com.spring.aisample.springAISample;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Objects;

@RestController
public class OpenAiChatController {


    private final ChatClient chatClient;

   /* @Autowired
    public OpenAiChatController(ChatClient chatClient) {
        this.chatClient = chatClient;
    }*/

  //  @GetMapping("/joke-service/simple".call;
   // }



    public OpenAiChatController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @GetMapping("/ai")
    String generation(String userInput) {
        return this.chatClient.prompt()
                .user(userInput)
                .call()
                .content();
    }

    @GetMapping("/ai/simple")
    public Map<String, String> completion(@RequestParam(value = "message", defaultValue = "Tell me a joke") String message) {
        return Map.of("completion", Objects.requireNonNull(this.chatClient.prompt().user(message).call().content()));
    }


    @GetMapping("/ai/second")
    Map<String, String> completion(@RequestParam(value = "message", defaultValue = "Tell me a joke") String message, String voice) {
        return Map.of("completion",
                Objects.requireNonNull(this.chatClient.prompt()
                        .system(sp -> sp.param("voice", voice))
                        .user(message)
                        .call()
                        .content()));
    }
}
