
package renbans.userapi.service;

import lombok.AllArgsConstructor;
import renbans.userapi.dto.request.PersonDTO;
import renbans.userapi.dto.response.MessageResponseDTO;
import renbans.userapi.entity.Person;
import renbans.userapi.exception.PersonNotFoundException;
import renbans.userapi.dto.mapper.PersonMapper;
import renbans.userapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;


    public MessageResponseDTO createPerson(PersonDTO personDTO) {

        Person personToSave = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(personToSave);

        return createMessageResponse(savedPerson.getId(), "Created person with ID ");
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO FindById(Long id) throws PersonNotFoundException {
        Person person = verifyifExists(id);

        return personMapper.toDTO(person);
    }

    public void delete(Long id) throws PersonNotFoundException {
        verifyifExists(id);

        personRepository.deleteById(id);
    }


    public MessageResponseDTO updateById(long id, PersonDTO personDTO) throws PersonNotFoundException {

        verifyifExists(id);

        Person personToUpdate = personMapper.toModel(personDTO);

        Person updatedPerson = personRepository.save(personToUpdate);

        return createMessageResponse(updatedPerson.getId(), "Update person with ID ");

    }

    private Person verifyifExists(Long id) throws PersonNotFoundException {
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }
}
