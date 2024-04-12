package renbans.personapi.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import renbans.personapi.dto.request.PersonDTO;
import renbans.personapi.dto.response.MessageResponseDTO;
import renbans.personapi.entity.Person;
import renbans.personapi.repository.PersonRepository;
import renbans.personapi.utills.PersonUtils;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static renbans.personapi.utills.PersonUtils.createFakeEntity;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    @Test
    void testGivenPersonDTOThenReturnSavedMessage() {
        PersonDTO personDTO = PersonUtils.createFakeDTO();
        Person espectedSavedPerson = createFakeEntity();

    when(personRepository.save(any(Person.class))).thenReturn(espectedSavedPerson);

        MessageResponseDTO espectedSuccesMessage = createdEspectedMessageResponse(espectedSavedPerson.getId());
        MessageResponseDTO succesMessage = personService.createPerson(personDTO);

        assertEquals(espectedSuccesMessage, succesMessage);

    }

    private static MessageResponseDTO createdEspectedMessageResponse(Long id) {
        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + id)
                .build();
    }
}
