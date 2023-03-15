package ru.students.lab_2.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ru.students.lab_2.model.Response;

@Service
@Qualifier("MyModifyService")
public class ModifyUid implements MyModifyService {
    
    @Override
    public Response modify(Response response) {

        response.setUid("New Uid");

        return response;
    }
}
