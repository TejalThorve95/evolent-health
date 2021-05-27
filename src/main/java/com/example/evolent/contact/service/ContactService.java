package com.example.evolent.contact.service;

import com.example.evolent.common.Converter;
import com.example.evolent.contact.dto.ContactDTO;
import com.example.evolent.contact.model.Contact;
import com.example.evolent.contact.repository.ContactRepository;
import com.example.evolent.exceptions.BaseIdentifiedException;
import com.example.evolent.exceptions.model.IdentifiedError;
import com.example.evolent.contact.model.ContactErrors;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContactService {

    private final ContactRepository repository;


    private final Converter<Contact, ContactDTO> contactDTOConverter;

    public ContactService(ContactRepository repository,
                          @Qualifier("contactDTOConverter") Converter<Contact, ContactDTO> contactDTOConverter) {
        this.repository = repository;
        this.contactDTOConverter = contactDTOConverter;
    }

    public ContactDTO update(Integer id, Contact contact) {
        Contact contactEntity = findOrThrow(id, ContactErrors.ECON001);
        contact.setId(contactEntity.getId());
        repository.save(contact);

        return contactDTOConverter.convert(contact);
    }


    public Contact findOrThrow(Integer id, IdentifiedError error) {

        return findByIdNotInActive(id).orElseThrow(() -> new BaseIdentifiedException(error));
    }

    public Optional<Contact> findByIdNotInActive(Integer id) {
        Optional<Contact> model = repository.findById(id);
        if (model.isPresent() && !(model.get().isStatus())) {
            return Optional.empty();
        }
        return model;
    }
}
