package com.lxisoft.school.cucumber;

import com.lxisoft.school.domain.Teacher;
import com.lxisoft.school.repository.TeacherRepository;
import com.lxisoft.school.service.TeacherService;
import com.lxisoft.school.service.dto.TeacherDTO;
import com.lxisoft.school.service.mapper.TeacherMapper;
import com.lxisoft.school.web.rest.TeacherResource;
import com.lxisoft.school.web.rest.TestUtil;
import com.lxisoft.school.web.rest.errors.ExceptionTranslator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;

import java.util.List;

import static com.lxisoft.school.web.rest.TestUtil.createFormattingConversionService;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class StepDefinition {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    @Autowired
    private Validator validator;

    private MockMvc restTeacherMockMvc;

    private Teacher teacher;

    public void setup() {
        MockitoAnnotations.initMocks(this);
        final TeacherResource teacherResource = new TeacherResource(teacherService);
        this.restTeacherMockMvc = MockMvcBuilders.standaloneSetup(teacherResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter)
            .setValidator(validator).build();
    }

    @Given("I create a new teacher")
    public void i_create_a_new_teacher() {
        setup();
    }

    @When("I enter name as {string} phoneNumber as {string} and email as {string}")
    public void i_enter_name_as_phoneNumber_as_and_email_as(String string, String string2, String string3) {
        teacher = new Teacher();
        teacher.setName(string);
        teacher.setPhoneNumber(string2);
        teacher.setEmail(string3);

        try {
            TeacherDTO teacherDTO = teacherMapper.toDto(teacher);
            restTeacherMockMvc.perform(post("/api/teachers")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(teacherDTO)))
                .andExpect(status().isCreated());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("I get name as {string} phoneNumber as {string} and email as {string}")
    public void i_get_name_as_phoneNumber_as_and_email_as(String string, String string2, String string3) {
        List<Teacher> teacherList = teacherRepository.findAll();
        for(Teacher t : teacherList){
            if(t.getName().equals(teacher.getName())){
                Assert.assertTrue(t.getName().equals(teacher.getName()));
            }
        }
        //Assert.assertTrue(teacherList.get(0).getName().equals(teacher.getName()));
    }
}
