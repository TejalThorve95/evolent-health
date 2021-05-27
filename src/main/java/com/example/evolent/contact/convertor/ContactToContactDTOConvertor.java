package com.example.evolent.contact.convertor;

import com.example.evolent.common.Converter;
import com.example.evolent.contact.dto.ContactDTO;
import com.example.evolent.contact.model.Contact;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("contactDTOConverter")
public class ContactToContactDTOConvertor implements Converter<Contact, ContactDTO> {

    @Override
    public ContactDTO convert(Contact input) {
        return new ContactDTO(input.getId(), input.getFirstName(), input.getLastName(), input.getPhone(), input.getEmail(), input.isStatus());
    }
}
