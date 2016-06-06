package com.pwr.internetowypomocnik.controller;

import com.pwr.internetowypomocnik.model.Record;
import com.pwr.internetowypomocnik.model.RecordDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;

/**
 * Created by Piotr on 2016-04-22.
 */
@RestController
public class RecordController {

    /**
     * GET /create  --> Create a new record and save it in the database.
     */
    @RequestMapping("/record/create")
    //String login, String password, String email, String first_name, String second_name, String sex, Integer age, Integer body_status_id, Integer diet_id
    public String create(Integer user_id, Integer exercise_id, float maximum){
        String id_record = "";
        try {
            Record record = new Record(user_id, exercise_id, maximum);
            recordDao.save(record);
            id_record = String.valueOf(record.getId_record());
        }
        catch (Exception ex) {
            return "Error creating the record: " + ex.toString();
        }
        return "record successfully created with id = " + id_record;
    }



    @RequestMapping(value="/record/get")
    public @ResponseBody Iterable<Record> getRecords()
    {
        Iterable<Record> recordList = null;
        Record tmpRecord = null;
        try{
            recordList = recordDao.findAll();
            Iterator<Record> recordIterator = recordList.iterator();
            tmpRecord = recordIterator.next();

        }
        catch (Exception ex){
        }
        return recordList;
    }


    /**
     * GET /delete  --> Delete the record having the passed id.
     */
    @RequestMapping("/record/delete")
    @ResponseBody
    public String delete(long id_record) {
        try {
            Record record = new Record(id_record);
           recordDao.delete(record);
        }
        catch (Exception ex) {
            return "Error deleting the record:" + ex.toString();
        }
        return "Record succesfully deleted!";
    }


    /**
     * GET /update  --> Update the email and the name for the record in the
     * database having the passed id.
     */
    @RequestMapping("/record/update")
    @ResponseBody
    public String updateRecord(long id_record, String login) {
        try {
            Record record = recordDao.findOne(id_record);
           // record.setLogin(login);
            recordDao.save(record);
        }
        catch (Exception ex) {
            return "Error updating the record: " + ex.toString();
        }
        return "Record succesfully updated!";
    }

    // Private fields

    @Autowired
    private RecordDao recordDao;

}
