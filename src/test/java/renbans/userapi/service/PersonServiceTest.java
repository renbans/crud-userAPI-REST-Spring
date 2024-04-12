package renbans.userapi.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import renbans.userapi.dto.request.PersonDTO;
import renbans.userapi.dto.response.MessageResponseDTO;
import renbans.userapi.entity.Person;
import renbans.userapi.repository.PersonRepository;
import renbans.userapi.utills.PersonUtils;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static renbans.userapi.utills.PersonUtils.createFakeEntity;

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
