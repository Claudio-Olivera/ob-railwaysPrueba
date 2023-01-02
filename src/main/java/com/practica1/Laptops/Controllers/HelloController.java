package com.practica1.Laptops.Controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${app.message}")
    String message;

    /*  @Value("${app.varexample}")
        String example;
    */
    @GetMapping("/api/saludo")
    public String saludar(){

        System.out.println(message);
      /*  System.out.println(example);*/

        return """
                <!doctype html>
                <html lang="en">
                  <head>
                    <!-- Required meta tags -->
                    <meta charset="utf-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1">
                                
                    <!-- Bootstrap CSS -->
                    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
                                
                    <title>Hello, world!</title>
                  </head>
                  <body>
                    <h1 class="text-success text-center m-5 p-5">Hello, world!</h1>
                  </body>
                  </html>
                """;
    }
}
