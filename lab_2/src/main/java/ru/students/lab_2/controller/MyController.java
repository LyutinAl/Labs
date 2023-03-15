package ru.students.lab_2.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import ru.students.lab_2.model.Response;
import ru.students.lab_2.service.MyModifyService;
import ru.students.lab_2.model.Request;

import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@RestController
public class MyController {

    private final MyModifyService myModifyService;

    public MyController(@Qualifier("ModifyErrorMessage") MyModifyService myModifyService) {
        this.myModifyService = myModifyService;
    }

    @PostMapping(value = "/feedback")
    public ResponseEntity<Response> feedback(@RequestBody Request request) {

        log.warn("Request: " + String.valueOf(request));

        Response response = Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(request.getSystemTime())
                .code("success")
                .errorCode("")
                .errorMessage("")
                .build();

        Response responseAfterModify = myModifyService.modify(response);

        log.warn("Response" + String.valueOf(responseAfterModify));

        return new ResponseEntity<>(responseAfterModify, HttpStatus.OK);
    }

}
