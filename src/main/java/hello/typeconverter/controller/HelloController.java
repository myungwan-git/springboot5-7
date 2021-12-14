package hello.typeconverter.controller;

import hello.typeconverter.type.IpPort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class HelloController {

  @GetMapping("/hello-v1")
  public String helloV1(HttpServletRequest request) {
    String data = request.getParameter("data");
    Integer intValud = Integer.valueOf(data);
    System.out.println("intValud = " + intValud);
    return "ok";
  }

  @GetMapping("/hello-v2")
  public String helloV2(@RequestParam Integer data) {
    System.out.println("data = " + data);
    return "v2 OK";
  }

  @GetMapping("/ip-port")
  public String ipPort(@RequestParam IpPort ipPort) {
    System.out.println("ipPort.getPort() = " + ipPort.getPort());
    System.out.println("ipPort.getIp() = " + ipPort.getIp());
    return "ip-port OK";
  }
}