package com.libraries.examples.services;

import com.libraries.examples.entities.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class HttpServiceTest {

    private HttpService httpService;

    @BeforeEach
    void setUp() {
        httpService = new HttpService();
    }

    @Test
    void send_get_return_model_isOk() throws InterruptedException, IOException {
        var url = "https://610adb7752d56400176b0013.mockapi.io/testes/account/1";
        var out = httpService.sendGetReturnModel(url, Account.class);
        assertNotNull(out);
    }

    @Test
    void send_get_return_list() throws IOException, InterruptedException {
        var url = "https://610adb7752d56400176b0013.mockapi.io/testes/account";
        var out = httpService.sendGetReturnList(url, Account.class);
        assertNotNull(out);
        assertTrue(out.size() > 0);
    }

    @Test
    void send_post_return_model() throws IOException, InterruptedException {
        var url = "https://610adb7752d56400176b0013.mockapi.io/testes/account";
        var account = new Account(1, "name", "12", "002");
        var out = httpService.sendPostReturnModel(url, Account.class, account);
        assertNotNull(out);
    }
}