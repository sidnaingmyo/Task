package com.example.task.controller;

import com.example.task.model.UserRequestModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ResponseHeader;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @ApiOperation("User login")

    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "Response Headers",
                    responseHeaders = {
                            @ResponseHeader(name = "authorization",
                                    description = "Bearer <JWT value here>",
                            response = String.class),
                            @ResponseHeader(name = "userId",
                                    description = "<Public User Id value here>",
                            response = String.class)
                    })
    })


    @PostMapping("/login")
        public void fakeMapping(@RequestBody UserRequestModel user){
            throw new IllegalArgumentException("This method should not be called");

        }
}
