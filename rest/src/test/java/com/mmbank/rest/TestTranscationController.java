package com.mmbank.rest;

import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mmbank.rest.controller.TransactionController;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebMvcTest(value=TransactionController.class, secure=false)
public class TestTranscationController extends RestApplicationTests{

	 
	
}
