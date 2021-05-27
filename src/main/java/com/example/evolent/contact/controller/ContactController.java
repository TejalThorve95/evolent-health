package com.example.evolent.contact.controller;

import com.example.evolent.common.Converter;
import com.example.evolent.common.Loggable;
import com.example.evolent.contact.dto.ContactDTO;
import com.example.evolent.contact.repository.ContactRepository;
import com.example.evolent.exceptions.BaseIdentifiedException;
import com.example.evolent.contact.model.Contact;
import com.example.evolent.contact.model.ContactErrors;
import com.example.evolent.contact.service.ContactService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Objects.nonNull;

@RestController
@RequestMapping("/api/v1/contacts")
@Api(tags = "Contact")
public class ContactController implements Loggable {

    private final ContactRepository repository;
    private final ContactService service;

    private final Converter<ContactDTO, Contact> dtoContactConverter;

    private final Converter<Contact, ContactDTO> contactDTOConverter;

    public ContactController(ContactRepository repository,
                             ContactService service,
                             @Qualifier("dtoContactConverter") Converter<ContactDTO, Contact> dtoContactConverter,
                             @Qualifier("contactDTOConverter") Converter<Contact, ContactDTO> contactDTOConverter) {
        this.repository = repository;
        this.service = service;
        this.dtoContactConverter = dtoContactConverter;
        this.contactDTOConverter = contactDTOConverter;
    }


    @ApiOperation(value = "Add a new Contact")
    @PostMapping
    public ContactDTO create(@RequestBody ContactDTO dto) {
        getLogger().info("start creating contact:");
        if (nonNull(dto.getId()) && repository.findById(dto.getId()).isPresent()) {
            throw new BaseIdentifiedException(ContactErrors.ECON002);
        }
        Contact contact = dtoContactConverter.convert(dto);
        return contactDTOConverter.convert(repository.save(contact));

    }

    @ApiOperation(value = "Load All Contacts")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ContactDTO> loadAll() {
        getLogger().info("start loadAll contacts");
        List<Contact> contacts = repository.findAllWithActiveStatus();
        return contactDTOConverter.convert(contacts);
    }

    @ApiOperation(value = "Update a new Contact")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ContactDTO updateContact(
            @RequestBody ContactDTO dto, @PathVariable Integer id) {
        getLogger().info("Updating contact:");
        return service.update(id, dtoContactConverter.convert(dto));

    }

    @ApiOperation(value = "Delete a Contact")
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    void deleteContact(@PathVariable Integer id) {
        Contact contact = service.findOrThrow(id, ContactErrors.ECON001);
        repository.softDeleteById(contact.getId());
    }

    @ApiOperation(value = "Get a Contact by Id")
    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ContactDTO getContact(@PathVariable Integer id) {
        Contact contact = service.findOrThrow(id, ContactErrors.ECON001);
        return contactDTOConverter.convert(contact);
    }


}
