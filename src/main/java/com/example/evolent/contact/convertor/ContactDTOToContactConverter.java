package com.example.evolent.contact.convertor;

import com.example.evolent.common.Converter;
import com.example.evolent.contact.dto.ContactDTO;
import com.example.evolent.contact.model.Contact;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("dtoContactConverter")
public class ContactDTOToContactConverter implements Converter<ContactDTO, Contact> {
    @Override
    public Contact convert(ContactDTO input) {
        return new Contact(input.getId(), input.getFirstName(), input.getLastName(), input.getPhone(), input.getEmail(), input.isStatus());
    }

}
