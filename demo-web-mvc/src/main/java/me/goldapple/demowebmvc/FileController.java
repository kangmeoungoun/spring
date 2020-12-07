package me.goldapple.demowebmvc;

import org.apache.tika.Tika;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;

/**
 * Created by jojoldu@gmail.com on 2020-12-06
 * Blog : http://jojoldu.tistory.com
 * Github : http://github.com/jojoldu
 */
@Controller
public class FileController {
    @Autowired
    private ResourceLoader resourceLoader;

    @GetMapping("/file")
    public String fildUploadForm(){
        return "files/index";
    }
    @PostMapping("/file")
    public String fildUpload(@RequestParam MultipartFile file,
                             RedirectAttributes attributes){
        String message = file.getOriginalFilename() + " is uploaded";
        attributes.addFlashAttribute("message",message);
        return "redirect:/file";
    }

    @GetMapping("/file/{filename}")
    public ResponseEntity<Resource> fileDownload(@PathVariable String filename) throws Exception{

        Resource resource = resourceLoader.getResource("classpath:templates/" + filename);
        File file = resource.getFile();
        Tika tika = new Tika();
        String mediaType = tika.detect(file);
        return ResponseEntity.ok()
                            .header(HttpHeaders.CONTENT_DISPOSITION,"attachement;filename=\""+file.getName()+"\"")
                            .header(HttpHeaders.CONTENT_TYPE,mediaType)
                            .header(HttpHeaders.CONTENT_LENGTH,file.length()+"")
                            .body(resource);

    }
}
