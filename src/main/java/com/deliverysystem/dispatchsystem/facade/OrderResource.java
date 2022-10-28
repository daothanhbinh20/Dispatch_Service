package com.deliverysystem.dispatchsystem.facade;

import com.deliverysystem.dispatchsystem.entities.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "order")
public class OrderResource {

  @PostMapping("/")
  public ResponseEntity<String> createOrder(@RequestBody final Order order) {
    return null;
  }
}
