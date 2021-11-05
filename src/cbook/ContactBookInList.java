package cbook;

import java.util.LinkedList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import exceptions.*;
public class ContactBookInList implements ContactBook {
    /**
     * A collection of contacts.
     */
    List<Contact> contacts;

    /**
     * Default constructor
     */
    public ContactBookInList() {
        contacts = new LinkedList<>();
    }

    @Override
    public boolean hasContact(String name) {
        return this.getContact(name) != null;
    }

    @Override
    public int getNumberOfContacts() {
        return contacts.size();
    }

    @Override
    public void addContact(String name, int phone, String email) throws ContactAlreadyExistsException {
        if (hasContact(name))
            throw new ContactAlreadyExistsException();
        else{
            Contact c = new ContactClass(name, phone, email);
            contacts.add(c);
        }
    }

    @Override
    public void deleteContact(String name) throws ContactDoesNotExistException {
        if (hasContact(name))
            contacts.remove(new ContactClass(name));
        else
            throw new ContactDoesNotExistException();
    }

    @Override
    /*
        Although we donÂ´t formally test the null point exception we can guarantee that it will never
        return a null, because hasContact(name) verification guarantee it
     */

    public int getPhone(String name) throws ContactDoesNotExistException {
        if (hasContact(name))
            return Objects.requireNonNull(this.getContact(name)).getPhone();
        else
            throw new ContactDoesNotExistException();
    }

    @Override
    public String getEmail(String name) throws ContactDoesNotExistException {
        if (hasContact(name))
            return Objects.requireNonNull(this.getContact(name)).getEmail();
        else
            throw new ContactDoesNotExistException();
    }

    @Override
    /*
        Although we donÂ´t formally test the null point exception we can guarantee that it will never
        return a null, because hasContact(name) verification guarantee it
     */

    public void setPhone(String name, int phone) throws ContactDoesNotExistException {
        if (hasContact(name))
            Objects.requireNonNull(this.getContact(name)).setPhone(phone);
        else
            throw new ContactDoesNotExistException();
    }

    @Override
    /*
        Although we donÂ´t formally test the null point exception we can guarantee that it will never
        return a null, because hasContact(name) verification guarantee it
     */

    public void setEmail(String name, String email) throws ContactDoesNotExistException {
        if (hasContact(name))
            Objects.requireNonNull(this.getContact(name)).setEmail(email);
        else
            throw new ContactDoesNotExistException();
    }

    @Override
    public Iterator<Contact> listContacts() {
        return contacts.iterator();
    }

    /**
     * @param name The contact name to lookup in the list
     * @return the <code>name</code> of the contact, if it exists,
     * otherwise <code>null</code>
     */
    private Contact getContact(String name) {
        for (Contact c: contacts)
            if (c.getName().equals(name))
                return c;
        return null;
    }
}
