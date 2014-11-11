package jp.cm.springbootsample;
  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
 
import jp.cm.springbootsample.service.HelloWorldService;
  
@Controller
@EnableAutoConfiguration
@ComponentScan
public class HelloController
{
  @Autowired
  private HelloWorldService helloWorldService;
   
  @RequestMapping("/")
  @ResponseBody
  public String home()
  {
    return helloWorldService.getHelloMessage();
  }
  
  public static void main(String[] arguments)
  {
    SpringApplication.run(HelloController.class, arguments);
  }
}