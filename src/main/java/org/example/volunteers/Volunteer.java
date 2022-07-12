package org.example.volunteers;

import java.util.Arrays;
import java.util.Locale;

import static java.util.stream.Collectors.joining;

public final class Volunteer {
    private Number id;
    private String firstName;
    private String lastName;
    private String nickName;
    private String eMail;
    private String phone;

    public int score = 0;

    public Volunteer(
            Number id,
            String firstName,
            String lastName,
            String nickName,
            String eMail,
            String phone
    ) {
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setNickName(nickName);
        setEMail(eMail);
        setPhone(phone);
    }

    public String getFullName () {
        return getFirstName().toLowerCase(Locale.ROOT).trim() + getLastName().toLowerCase(Locale.ROOT).trim();
    }

    @Override
    public String toString() {
        return Arrays.stream(new String[]{firstName,lastName,nickName,eMail,phone})
            .map(attribute -> String.format("\"%s\"", attribute))
            .collect(joining(";"));
    }

    public int fiabilityScore() {
        int newScore = 0;

        if (this.firstName != "") newScore++;
        if (this.lastName != "") newScore++;
        if (this.nickName != "") newScore++;
        if (this.eMail != "") newScore++;
        if (this.phone != "") newScore++;

        this.score = newScore;

        return this.score;
    }

    public Number getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public String getEMail() {
        return eMail;
    }

    public String getPhone() {
        return phone;
    }

    public void setId(Number id){
        this.id = id;
    }

    public void setFirstName(String firstname){
        this.firstName = firstname;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setNickName(String nickName){
        this.nickName = nickName;
    }

    public void setEMail(String email){
        this.eMail = email;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }
}
