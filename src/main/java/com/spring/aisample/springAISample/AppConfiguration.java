package com.spring.aisample.springAISample;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.ai.openai.api.OpenAiAudioApi;
import org.springframework.ai.openai.api.OpenAiImageApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ai.openai.audio.speech.*;

@Configuration
public class AppConfiguration {



  /*  @Bean
    SpeechClient speechClient(@Value("${spring.ai.openai.api-key}") String apiKey) {
        return new OpenAiAudioSpeechClient(new OpenAiAudioApi(apiKey));
    }*/

  /*  @Bean
    ImageClient imageClient(@Value("${spring.ai.openai.api-key}") String apiKey) {
        return new OpenAiImageClient(new OpenAiImageApi(apiKey));
    }*/

   /* @Bean
    ChatClient chatClient(@Value("${spring.ai.openai.api-key}") String apiKey) {
        return new OpenAiChatClient(new OpenAiApi(apiKey));
    }*/

    @Bean
    ChatClient chatClient(ChatClient.Builder builder) {
        return builder.defaultSystem("You are a friendly chat bot that answers question in the voice of a Pirate")
                .build();
    }
}
