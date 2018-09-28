package ths.project.thsboot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import ths.project.thsboot.model.Girl;
import ths.project.thsboot.persistence.service.GirlService;

import java.util.List;

/**
 * @author: wangrd
 * @since: 2018年07月20日 22:18:47
 * @Desc:
 */
@RestController
@RequestMapping(value = "/girl")
public class GirlController {
    @Autowired
    private GirlService girlService;

    @RequestMapping(value = "/list")
    public List<Girl> list(@RequestParam(required = false) String name) {
        List<Girl> girls;
        if (StringUtils.hasText(name)) {
            girls = girlService.findByName(name);
        } else {
            girls = girlService.list();
        }
        return girls;
    }

    @PostMapping(value = "/save")
    public Girl save(@RequestParam(name = "name") String name,
                     @RequestParam(name = "cupSize") String cupSize,
                     @RequestParam(name = "age", defaultValue = "18") Integer age) {
        Girl girl = new Girl();
        girl.setName(name);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlService.save(girl);
    }

    @PostMapping(value = "/update")
    public Girl update(@RequestParam(name = "id") Integer id,
                       @RequestParam(name = "name") String name,
                       @RequestParam(name = "cupSize") String cupSize,
                       @RequestParam(name = "age", defaultValue = "18") Integer age) {
        Girl girl = girlService.getOne(id);
        girl.setName(name);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlService.save(girl);
    }

    @PostMapping(value = "/delete")
    public List<Girl> delete(@RequestParam(name = "id") Integer id) {
        girlService.deleteById(id);
        return girlService.list();
    }

    @GetMapping(value = "/initData")
    public List<Girl> initData() {
        girlService.initData(2000);
        return girlService.list();
    }
}
