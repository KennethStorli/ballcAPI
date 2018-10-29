package no.experis.ballc.controller;


import no.experis.ballc.model.*;
import no.experis.ballc.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class PersonController {

    @Autowired
    PersonJpaRepository personRepository;
    @Autowired
    AddressJpaRepository addressRepository;
    @Autowired
    ContactJpaRepository contactRepository;
    @Autowired
    TeamJpaRepository teamRepository;
    @Autowired
    PlayerJpaRepository playerRepository;
    @Autowired
    CoachJpaRepository coachRepository;
    @Autowired
    OwnerJpaRepository ownerRepository;
    @Autowired
    MatchJpaRepository matchRepository;
    @Autowired
    AssociationJpaRepository associationRepository;
    @Autowired
    SeasonJpaRepository seasonRepository;
    @Autowired
    LocationJpaRepository locationRepository;


// Persons
    /*@GetMapping("/persons")
    public Page<Person> getAllPersons(Pageable pageable){
        return personRepository.findAll(pageable);
    }*/
    @GetMapping("/persons")
    @CrossOrigin(origins = "*")
    public List<Person> getAllPersons(){
        return personRepository.findAll();
    }

    @GetMapping("/persons/{id}")
    public Person getPerson(@PathVariable int id){
        Optional<Person> person = personRepository.findById(id);
        return person.get();
    }

    @PostMapping("/persons")
    @CrossOrigin(origins = "*")
    public Person createPerson(@RequestBody Map<String, String> body) throws ParseException {
        Optional<Address> address = addressRepository.findById(Integer.parseInt(body.get("address")));
        String first_name = body.get("first_name");
        String last_name = body.get("last_name");
        return personRepository.save(new Person(address.get(), first_name, last_name, parseDate(body.get("date_of_birth"))));
    }

    @PutMapping("/persons/{id}")
    public Person updatePerson(@PathVariable int id,
                           @RequestBody Map<String, String> body) throws ParseException {

        Optional<Address> address = addressRepository.findById(Integer.parseInt(body.get("address")));
        Optional<Person> oldPerson = personRepository.findById(id);
        Person newPerson = oldPerson.get();

        newPerson.setAddress(address.get());
        newPerson.setFirst_name(body.get("first_name"));
        newPerson.setLast_name(body.get("last_name"));
        newPerson.setDate_of_birth(parseDate(body.get("date_of_birth")));
        return personRepository.save(newPerson);
    }

    @DeleteMapping("/persons/{id}")
    public void deletePerson(@PathVariable int id) {
        personRepository.deleteById(id);
    }
// Persons end

// Contacts
    @GetMapping("/contacts")
    public List<Contact> getAllContacts(){
        return contactRepository.findAll();
    }

    @GetMapping("/contacts/{id}")
    public Contact getContact(@PathVariable int id){
        Optional<Contact> contact = contactRepository.findById(id);
        return contact.get();
    }

    @PostMapping("/contacts")
    public Contact createContact(@RequestBody Map<String, String> body) {
        String contact_type = body.get("contact_type");
        String contact_detail = body.get("contact_detail");
        Optional<Person> person = personRepository.findById(Integer.parseInt(body.get("person")));
        return contactRepository.save(new Contact(contact_type, contact_detail, person.get()));
    }

    @PutMapping("/contacts/{id}")
    public Contact updateContact(@PathVariable int id,
                                 @RequestBody Map<String, String> body) {

        Optional<Person> person = personRepository.findById(Integer.parseInt(body.get("person")));
        Optional<Contact> oldContact = contactRepository.findById(id);
        Contact newContact = oldContact.get();

        newContact.setContact_type("contact_type");
        newContact.setContact_detail(body.get("contact_detail"));
        newContact.setPerson(person.get());
        return contactRepository.save(newContact);
    }

    @DeleteMapping("/contacts/{id}")
    public void deleteContact(@PathVariable int id) {
        contactRepository.deleteById(id);
    }
// Contacts end

// Teams
    @GetMapping("/teams")
    public List<Team> getAllTeams(){
        return teamRepository.findAll();
    }

    @GetMapping("/teams/{id}")
    public Team getTeam(@PathVariable int id){
        Optional<Team> team = teamRepository.findById(id);
        return team.get();
    }

    @PostMapping("/teams")
    public Team createTeam(@RequestBody Map<String, String> body) {
        Optional<Association> association = associationRepository.findById(Integer.parseInt(body.get("association")));
        Optional<Coach> coach = coachRepository.findById(Integer.parseInt(body.get("coach")));
        Optional<Owner> owner = ownerRepository.findById(Integer.parseInt(body.get("owner")));
        Optional<Location> location = locationRepository.findById(Integer.parseInt(body.get("location")));
        return teamRepository.save(new Team(association.get(), coach.get(), owner.get(), location.get()));
    }

    @PutMapping("/teams/{id}")
    public Team updateTeam(@PathVariable int id,
                                     @RequestBody Map<String, String> body) {
        Optional<Association> association = associationRepository.findById(Integer.parseInt(body.get("association")));
        Optional<Coach> coach = coachRepository.findById(Integer.parseInt(body.get("coach")));
        Optional<Owner> owner = ownerRepository.findById(Integer.parseInt(body.get("owner")));
        Optional<Location> location = locationRepository.findById(Integer.parseInt(body.get("location")));

        Optional<Team> oldTeam = teamRepository.findById(id);
        Team newTeam = oldTeam.get();

        newTeam.setAssociation(association.get());
        newTeam.setCoach(coach.get());
        newTeam.setOwner(owner.get());
        newTeam.setLocation(location.get());
        return teamRepository.save(newTeam);
    }

    @DeleteMapping("/teams/{id}")
    public void deleteTeam(@PathVariable int id) {
        teamRepository.deleteById(id);
    }
// Teams end

// Coach
    @GetMapping("/coaches")
    public List<Coach> getAllCoaches(){
        return coachRepository.findAll();
    }

    @GetMapping("/coaches/{id}")
    public Coach getCoach(@PathVariable int id){
        Optional<Coach> coach = coachRepository.findById(id);
        return coach.get();
    }

    @PostMapping("/coaches")
    public Coach createCoach(@RequestBody Map<String, String> body) {
        Optional<Person> person = personRepository.findById(Integer.parseInt(body.get("person")));
        Optional<Team> team = teamRepository.findById(Integer.parseInt(body.get("team")));
        return coachRepository.save(new Coach(person.get(), team.get()));
    }

    @PutMapping("/coaches/{id}")
    public Coach updateCoach(@PathVariable int id,
                           @RequestBody Map<String, String> body) {
        Optional<Coach> oldCoach = coachRepository.findById(id);
        Coach newCoach = oldCoach.get();

        Optional<Person> person = personRepository.findById(Integer.parseInt(body.get("person")));
        Optional<Team> team = teamRepository.findById(Integer.parseInt(body.get("team")));

        newCoach.setPerson(person.get());
        newCoach.setTeam(team.get());
        return coachRepository.save(newCoach);
    }

    @DeleteMapping("/coaches/{id}")
    public void deleteCoach(@PathVariable int id) {
        coachRepository.deleteById(id);
    }
// Coach end

// Player
    @GetMapping("/players")
    public List<Player> getAllPlayers(){
        return playerRepository.findAll();
    }

    @GetMapping("/players/{id}")
    public Player getPlayer(@PathVariable int id){
        Optional<Player> player = playerRepository.findById(id);
        return player.get();
    }

    @PostMapping("/players")
    public Player createPlayer(@RequestBody Map<String, String> body) {
        String normal_position = body.get("normal_position");
        int number = Integer.parseInt(body.get("number"));
        Optional<Person> person = personRepository.findById(Integer.parseInt(body.get("person")));
        Optional<Team> team = teamRepository.findById(Integer.parseInt(body.get("team")));
        return playerRepository.save(new Player(normal_position, number, person.get(), team.get()));
    }

    @PutMapping("/players/{id}")
    public Player updatePlayer(@PathVariable int id,
                               @RequestBody Map<String, String> body) {
        Optional<Player> oldPlayer = playerRepository.findById(id);
        Player newPlayer = oldPlayer.get();

        Optional<Person> person = personRepository.findById(Integer.parseInt(body.get("person")));
        Optional<Team> team = teamRepository.findById(Integer.parseInt(body.get("team")));

        newPlayer.setNormal_position(body.get("normal_position"));
        newPlayer.setNumber(Integer.parseInt(body.get("number")));
        newPlayer.setPerson(person.get());
        newPlayer.setTeam(team.get());
        return playerRepository.save(newPlayer);
    }

    @DeleteMapping("/players/{id}")
    public void deletePlayer(@PathVariable int id) {
        playerRepository.deleteById(id);
    }
// Player end

    //Owner
    @GetMapping("/owners")
    public List<Owner> getAllOwners(){
        return ownerRepository.findAll();
    }

    @GetMapping("/owners/{id}")
    public Owner getOwner(@PathVariable int id){
        Optional<Owner> owner = ownerRepository.findById(id);
        return owner.get();
    }

    @PostMapping("/owners")
    public Owner createOwner(@RequestBody Map<String, String> body) {
        Optional<Person> person = personRepository.findById(Integer.parseInt(body.get("person")));
        Optional<Team> team = teamRepository.findById(Integer.parseInt(body.get("team")));
        return ownerRepository.save(new Owner(person.get(), team.get()));
    }

    @PutMapping("/owners/{id}")
    public Owner updateOwner(@PathVariable int id,
                             @RequestBody Map<String, String> body) {
        Optional<Owner> oldOwner = ownerRepository.findById(id);
        Owner newOwner = oldOwner.get();

        Optional<Person> person = personRepository.findById(Integer.parseInt(body.get("person")));
        Optional<Team> team = teamRepository.findById(Integer.parseInt(body.get("team")));

        newOwner.setPerson(person.get());
        newOwner.setTeam(team.get());
        return ownerRepository.save(newOwner);
    }

    @DeleteMapping("/owners/{id}")
    public void deleteOwner(@PathVariable int id) {
        ownerRepository.deleteById(id);
    }
    //Owner end


// Match
    @GetMapping("/matches")
    public List<Match> getAllMatches(){
        List<Match> test = matchRepository.findAll();
        return test;
    }

    @GetMapping("/matches/{id}")
    public Match getMatch(@PathVariable int id){
        Optional<Match> match = matchRepository.findById(id);
        return match.get();
    }

    @PostMapping("/matches")
    public Match createMatch(@RequestBody Map<String, String> body) throws ParseException {
        Optional<Season> season = seasonRepository.findById(Integer.parseInt(body.get("season")));
        Optional<Location> location = locationRepository.findById(Integer.parseInt(body.get("location")));
        Optional<Team> home_team = teamRepository.findById(Integer.parseInt(body.get("home_team")));
        Optional<Team> away_team = teamRepository.findById(Integer.parseInt(body.get("away_team")));
        return matchRepository.save(new Match(parseDate(body.get("match_date")), season.get(), location.get(), home_team.get(), away_team.get()));
    }

    @PutMapping("/matches/{id}")
    public Match updateMatch(@PathVariable int id,
                               @RequestBody Map<String, String> body) {
        Optional<Match> oldMatch = matchRepository.findById(id);
        Match newMatch = oldMatch.get();

        Optional<Season> season = seasonRepository.findById(Integer.parseInt(body.get("season")));
        Optional<Location> location = locationRepository.findById(Integer.parseInt(body.get("location")));
        Optional<Team> home_team = teamRepository.findById(Integer.parseInt(body.get("home_team")));
        Optional<Team> away_team = teamRepository.findById(Integer.parseInt(body.get("away_team")));

        newMatch.setSeason(season.get());
        newMatch.setLocation(location.get());
        newMatch.setHome_team(home_team.get());
        newMatch.setAway_team(away_team.get());
        // TODO: Update results, goals and positions
        /*
        newMatch.setMatchGoals();
        newMatch.setMatchPositions();
        newMatch.setResults();
        */
        return matchRepository.save(newMatch);
    }

    @DeleteMapping("/match/{id}")
    public void deleteMatch(@PathVariable int id) {
        matchRepository.deleteById(id);
    }
// Match end


// Helper methods
    private Date parseDate(String dateString) throws ParseException {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.parse(dateString);
    }
}
