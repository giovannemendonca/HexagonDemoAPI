package com.giovanne.hexagonal.application.ports.out;

public interface SendCpfForValidateOutputPort {

    void send(String cpf);
}
