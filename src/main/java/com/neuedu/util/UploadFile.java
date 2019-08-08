package com.neuedu.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UploadFile {

    public static String upload(MultipartFile file){
        String uuid= UUID.randomUUID().toString();

        String fileName=file.getOriginalFilename();

        String fileExtendName=fileName.substring(fileName.lastIndexOf("."));

        String newFileName=uuid+fileExtendName;

        File path=new File("D:\\文档\\实训\\test\\business-manager\\upload");
        if(!path.exists()){
            path.mkdir();
        }
        File newFile=new File(path,newFileName);

        try {
            file.transferTo(newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return newFileName;

    }

    public static List<String> upload(MultipartFile[] files){
        List<String> list=new ArrayList<>();
        for (MultipartFile file:files) {
            String uuid= UUID.randomUUID().toString();

            String fileName=file.getOriginalFilename();

            String fileExtendName=fileName.substring(fileName.lastIndexOf("."));

            String newFileName=uuid+fileExtendName;

            File path=new File("D:\\文档\\实训\\test\\business-manager\\upload");
            if(path.exists()){
                path.mkdir();
            }
            File newFile=new File(path,newFileName);

            try {
                file.transferTo(newFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            list.add(newFileName);
        }
        return list;
    }
}
