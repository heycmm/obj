package cc.orcl.obj;

import org.dromara.easyes.starter.register.EsMapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EsMapperScan("cc.orcl.obj.mapper")
public class ObjApplication {

    public static void main(String[] args) {
        SpringApplication.run(ObjApplication.class, args);
    }

}
