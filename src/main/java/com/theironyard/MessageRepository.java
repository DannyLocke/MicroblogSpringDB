package com.theironyard;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by dlocke on 12/23/16.
 */

public interface MessageRepository extends CrudRepository<Message, Integer> {

}
