package no.experis.ballc.controller;


import no.experis.ballc.model.*;
import no.experis.ballc.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

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
    @Autowired
    ResultJpaRepository resultRepository;
    @Autowired
    MatchGoalJpaRepository matchGoalRepository;
    @Autowired
    GoalTypeJpaRepository goalTypeRepository;
    @Autowired
    MatchPositionJpaRepository matchPositionRepository;

// Addresses
    @GetMapping("/addresses")
    @CrossOrigin(origins = "*")
    public List<Address> getAllAddresses(){
        return addressRepository.findAll();
    }

    @GetMapping("/addresses/{id}")
    @CrossOrigin(origins = "*")
    public Address getAddress(@PathVariable int id){
        Optional<Address> address = addressRepository.findById(id);
        return address.get();
    }

    @PostMapping("/addresses")
    @CrossOrigin(origins = "*")
    public int createAddress(@RequestBody Map<String, String> body) {
        String address_line_1 = body.get("address_line_1");
        String address_line_2 = body.get("address_line_2");
        String postal_code = body.get("postal_code");
        String city = body.get("city");
        String country = body.get("country");
        String address_line_3 = body.get("address_line_3");
        Address address = addressRepository.save(new Address(address_line_1, address_line_2, postal_code, city, country, address_line_3));
        return address.getAddress_id();
    }

    @PutMapping("/addresses/{id}")
    @CrossOrigin(origins = "*")
    public Address updateAddress(@PathVariable int id,
                               @RequestBody Map<String, String> body) {
        Optional<Location> location = locationRepository.findById(Integer.parseInt(body.get("location")));
        Optional<Address> oldAddress = addressRepository.findById(id);
        Address newAddress = oldAddress.get();

        newAddress.setAddress_line_1(body.get("address_line_1"));
        newAddress.setAddress_line_2(body.get("address_line_2"));
        newAddress.setPostal_code(body.get("postal_code"));
        newAddress.setCity(body.get("city"));
        newAddress.setCountry(body.get("country"));
        newAddress.setAddress_line_3(body.get("address_line_3"));
        newAddress.setLocation(location.get());
        return addressRepository.save(newAddress);
    }

    @DeleteMapping("/addresses/{id}")
    @CrossOrigin(origins = "*")
    public void deleteAddress(@PathVariable int id) {
        addressRepository.deleteById(id);
    }
// Addresses end

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
    @CrossOrigin(origins = "*")
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
    @CrossOrigin(origins = "*")
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
    @CrossOrigin(origins = "*")
    public void deletePerson(@PathVariable int id) {
        personRepository.deleteById(id);
    }
// Persons end

// Contacts
    @GetMapping("/contacts")
    @CrossOrigin(origins = "*")
    public List<Contact> getAllContacts(){
        return contactRepository.findAll();
    }

    @GetMapping("/contacts/{id}")
    @CrossOrigin(origins = "*")
    public Contact getContact(@PathVariable int id){
        Optional<Contact> contact = contactRepository.findById(id);
        return contact.get();
    }

    @PostMapping("/contacts")
    @CrossOrigin(origins = "*")
    public Contact createContact(@RequestBody Map<String, String> body) {
        String contact_type = body.get("contact_type");
        String contact_detail = body.get("contact_detail");
        Optional<Person> person = personRepository.findById(Integer.parseInt(body.get("person")));
        return contactRepository.save(new Contact(contact_type, contact_detail, person.get()));
    }

    @PutMapping("/contacts/{id}")
    @CrossOrigin(origins = "*")
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
    @CrossOrigin(origins = "*")
    public void deleteContact(@PathVariable int id) {
        contactRepository.deleteById(id);
    }
// Contacts end

// Teams
    @GetMapping("/teams")
    @CrossOrigin(origins = "*")
    public List<Team> getAllTeams(){
        return teamRepository.findAll();
    }

    @GetMapping("/teams/{id}")
    @CrossOrigin(origins = "*")
    public Team getTeam(@PathVariable int id){
        Optional<Team> team = teamRepository.findById(id);
        return team.get();
    }

    @PostMapping("/teams")
    @CrossOrigin(origins = "*")
    public Team createTeam(@RequestBody Map<String, String> body) {
        String teamName = body.get("teamName");
        Optional<Association> association = associationRepository.findById(Integer.parseInt(body.get("association")));
        Optional<Coach> coach = coachRepository.findById(Integer.parseInt(body.get("coach")));
        Optional<Owner> owner = ownerRepository.findById(Integer.parseInt(body.get("owner")));
        Optional<Location> location = locationRepository.findById(Integer.parseInt(body.get("location")));
        return teamRepository.save(new Team(teamName, association.get(), coach.get(), owner.get(), location.get()));
    }

    @PutMapping("/teams/{id}")
    @CrossOrigin(origins = "*")
    public Team updateTeam(@PathVariable int id,
                                     @RequestBody Map<String, String> body) {
        Optional<Association> association = associationRepository.findById(Integer.parseInt(body.get("association")));
        Optional<Coach> coach = coachRepository.findById(Integer.parseInt(body.get("coach")));
        Optional<Owner> owner = ownerRepository.findById(Integer.parseInt(body.get("owner")));
        Optional<Location> location = locationRepository.findById(Integer.parseInt(body.get("location")));

        Optional<Team> oldTeam = teamRepository.findById(id);
        Team newTeam = oldTeam.get();

        newTeam.setTeamName(body.get("teamName"));
        newTeam.setAssociation(association.get());
        newTeam.setCoach(coach.get());
        newTeam.setOwner(owner.get());
        newTeam.setLocation(location.get());
        return teamRepository.save(newTeam);
    }

    @DeleteMapping("/teams/{id}")
    @CrossOrigin(origins = "*")
    public void deleteTeam(@PathVariable int id) {
        teamRepository.deleteById(id);
    }
// Teams end

// Coach
    @GetMapping("/coaches")
    @CrossOrigin(origins = "*")
    public List<Coach> getAllCoaches(){
        return coachRepository.findAll();
    }

    @GetMapping("/coaches/{id}")
    @CrossOrigin(origins = "*")
    public Coach getCoach(@PathVariable int id){
        Optional<Coach> coach = coachRepository.findById(id);
        return coach.get();
    }

    @PostMapping("/coaches")
    @CrossOrigin(origins = "*")
    public Coach createCoach(@RequestBody Map<String, String> body) {
        Optional<Person> person = personRepository.findById(Integer.parseInt(body.get("person")));
        Optional<Team> team = teamRepository.findById(Integer.parseInt(body.get("team")));
        return coachRepository.save(new Coach(person.get(), team.get()));
    }

    @PutMapping("/coaches/{id}")
    @CrossOrigin(origins = "*")
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
    @CrossOrigin(origins = "*")
    public void deleteCoach(@PathVariable int id) {
        coachRepository.deleteById(id);
    }
// Coach end

// Player
    @GetMapping("/players")
    @CrossOrigin(origins = "*")
    public List<Player> getAllPlayers(){
        return playerRepository.findAll();
    }

    @GetMapping("/players/{id}")
    @CrossOrigin(origins = "*")
    public Player getPlayer(@PathVariable int id){
        Optional<Player> player = playerRepository.findById(id);
        return player.get();
    }

    @PostMapping("/players")
    @CrossOrigin(origins = "*")
    public Player createPlayer(@RequestBody Map<String, String> body) {
        String normal_position = body.get("normal_position");
        int number = Integer.parseInt(body.get("number"));
        Optional<Person> person = personRepository.findById(Integer.parseInt(body.get("person")));
        Optional<Team> team = teamRepository.findById(Integer.parseInt(body.get("team")));
        return playerRepository.save(new Player(normal_position, number, person.get(), team.get()));
    }

    @PutMapping("/players/{id}")
    @CrossOrigin(origins = "*")
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
    @CrossOrigin(origins = "*")
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
//        Optional<Team> team = teamRepository.findById(Integer.parseInt(body.get("team")));
        return ownerRepository.save(new Owner(person.get()/*, team.get()*/));
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
    @CrossOrigin(origins = "*")
    public List<Match> getAllMatches(){
        List<Match> test = matchRepository.findAll();
        return test;
    }

    @GetMapping("/matches/{id}")
    @CrossOrigin(origins = "*")
    public Match getMatch(@PathVariable int id){
        Optional<Match> match = matchRepository.findById(id);
        return match.get();
    }

    @PostMapping("/matches")
    @CrossOrigin(origins = "*")
    public Match createMatch(@RequestBody Map<String, String> body) throws ParseException {
        Optional<Season> season = seasonRepository.findById(Integer.parseInt(body.get("season")));
        Optional<Location> location = locationRepository.findById(Integer.parseInt(body.get("location")));
        Optional<Team> home_team = teamRepository.findById(Integer.parseInt(body.get("home_team")));
        Optional<Team> away_team = teamRepository.findById(Integer.parseInt(body.get("away_team")));
        return matchRepository.save(new Match(parseDate(body.get("match_date")), season.get(), location.get(), home_team.get(), away_team.get()));
    }

    @PutMapping("/matches/{id}")
    @CrossOrigin(origins = "*")
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

    @DeleteMapping("/matches/{id}")
    @CrossOrigin(origins = "*")
    public void deleteMatch(@PathVariable int id) {
        matchRepository.deleteById(id);
    }
// Match end

// Location
    @GetMapping("/locations")
    @CrossOrigin(origins = "*")
    public List<Location> getAllLocations(){
        return locationRepository.findAll();
    }

    @GetMapping("/locations/{id}")
    @CrossOrigin(origins = "*")
    public Location getLocation(@PathVariable int id){
        Optional<Location> location = locationRepository.findById(id);
        return location.get();
    }

    @PostMapping("/locations")
    @CrossOrigin(origins = "*")
    public Location createLocation(@RequestBody Map<String, String> body) {
        String name = body.get("name");
        String description = body.get("description");
        Optional<Address> address = addressRepository.findById(Integer.parseInt(body.get("address")));
        return locationRepository.save(new Location(name, description, address.get()));
    }

    @PutMapping("/locations/{id}")
    @CrossOrigin(origins = "*")
    public Location updateLocation(@PathVariable int id,
                             @RequestBody Map<String, String> body) {
        Optional<Location> oldLocation = locationRepository.findById(id);
        Location newLocation = oldLocation.get();

        Optional<Address> address = addressRepository.findById(Integer.parseInt(body.get("address")));

        newLocation.setName(body.get("name"));
        newLocation.setDescription(body.get("description"));
        newLocation.setAddress(address.get());
        // TODO: Update FootballMatches and Teams

        /*newLocation.setFootballMatches();
        newLocation.setTeams();*/

        return locationRepository.save(newLocation);
    }
    @DeleteMapping("/locations/{id}")
    @CrossOrigin(origins = "*")
    public void deleteLocation(@PathVariable int id) {
        locationRepository.deleteById(id);
    }
// Location end

//association

    @GetMapping("/associations")
    public List<Association> getAllAssociations(){
        return associationRepository.findAll();
    }

    @GetMapping("/associations/{id}")
    public Association getAssociation(@PathVariable int id){
        Optional<Association> association = associationRepository.findById(id);
        return association.get();
    }

    @PostMapping("/associations")
    public Association createAssociation(@RequestBody Map<String, String> body) throws ParseException {
        String name = body.get("name");
        String desc = body.get("description");

        return associationRepository.save(new Association(name , desc));
    }

    @PutMapping("/associations/{id}")
    public Association updateAssociation(@PathVariable int id, @RequestBody Map<String, String> body) throws ParseException {
        String name = body.get("name");
        String desc = body.get("description");
        Association newAss = new Association(name, desc);
        newAss.setAssociation_id(id);
        return associationRepository.save(newAss);
    }

    @DeleteMapping("/associations/{id}")
    @CrossOrigin(origins = "*")
    public void deleteAssociation(@PathVariable int id) {
        associationRepository.deleteById(id);
    }

// Association end

// Result
    @GetMapping("/results")
    public List<Result> getAllResults(){
        return resultRepository.findAll();
    }

    @GetMapping("/results/{teamId}/{matchId}")
    public Result getResult(@PathVariable int teamId, @PathVariable int matchId){
        //make new ResultID object
        //need Team object and Match object
        //get two ids and find each object by id
        //use objects to create resultID
        //findbyID paste in object
        ResultId resId = new ResultId();
        Optional<Team> team =  teamRepository.findById(teamId);
        resId.setTeam(team.get());
        resId.setFootballMatch(matchRepository.findById(matchId).get());
        Optional<Result> result = resultRepository.findById(resId);
        return result.get();
    }

    @PostMapping("/results")
    public Result createResult(@RequestBody Map<String, String> body) throws ParseException {
        int teamId = Integer.valueOf(body.get("teamId"));
        int matchId = Integer.valueOf(body.get("matchId"));
        ResultId resId = new ResultId();
        Team idTeam = teamRepository.findById(teamId).get();
        resId.setTeam(idTeam);
        Match idMatch = matchRepository.findById(matchId).get();
        resId.setFootballMatch(idMatch);

        int score = Integer.valueOf(body.get("score"));
        String result = body.get("result");

        Result insertResult = new Result();
        insertResult.setPrimaryKey(resId);
        insertResult.setResult(result);
        insertResult.setScore(score);
        return resultRepository.save(insertResult);
    }

    @PutMapping("/results")
    public Result updateResult(@RequestBody Map<String, String> body) throws ParseException {
        ResultId resId = new ResultId();
        resId.setTeam(teamRepository.findById(Integer.valueOf(body.get("teamId"))).get());
        resId.setFootballMatch(matchRepository.findById(Integer.valueOf(body.get("matchId"))).get());

        Result newResult = resultRepository.findById(resId).get();

        newResult.setResult(body.get("result"));
        newResult.setScore(Integer.valueOf(body.get("score")));
        return resultRepository.save(newResult);
    }

    @DeleteMapping("/results/{teamId}/{matchId}")
    @CrossOrigin(origins = "*")
    public void deleteResult(@PathVariable int teamId, @PathVariable int matchId) {
        ResultId delId = new ResultId();
        Team idTeam = teamRepository.findById(teamId).get();
        delId.setTeam(idTeam);
        Match idMatch = matchRepository.findById(matchId).get();
        delId.setFootballMatch(idMatch);
        resultRepository.deleteById(delId);
    }

// Result end

// MatchGoals
    @GetMapping("/matchgoals")
    @CrossOrigin(origins = "*")
    public List<MatchGoal> getAllMatchGoals(){
        return matchGoalRepository.findAll();
    }

    @GetMapping("/matchgoals/{id}")
    @CrossOrigin(origins = "*")
    public MatchGoal getMatchGoal(@PathVariable int id){
        Optional<MatchGoal> matchGoal = matchGoalRepository.findById(id);
        return matchGoal.get();
    }

    @PostMapping("/matchgoals")
    @CrossOrigin(origins = "*")
    public MatchGoal createMatchGoal(@RequestBody Map<String, String> body) {
        String description = body.get("description");
        Optional<GoalType> goalType = goalTypeRepository.findById(Integer.parseInt(body.get("goalType")));
        Optional<Match> footballMatch = matchRepository.findById(Integer.parseInt(body.get("footballMatch")));
        Optional<Player> player = playerRepository.findById(Integer.parseInt(body.get("player")));
        return matchGoalRepository.save(new MatchGoal(description, goalType.get(), footballMatch.get(), player.get()));
    }

    @PutMapping("/matchgoals/{id}")
    @CrossOrigin(origins = "*")
    public MatchGoal updateMatchGoal(@PathVariable int id,
                                   @RequestBody Map<String, String> body) {
        Optional<MatchGoal> oldMatchGoal = matchGoalRepository.findById(id);
        MatchGoal newMatchGoal = oldMatchGoal.get();

        Optional<GoalType> goalType = goalTypeRepository.findById(Integer.parseInt(body.get("goalType")));
        Optional<Match> footballMatch = matchRepository.findById(Integer.parseInt(body.get("footballMatch")));
        Optional<Player> player = playerRepository.findById(Integer.parseInt(body.get("player")));

        newMatchGoal.setDescription(body.get("description"));
        newMatchGoal.setGoalType(goalType.get());
        newMatchGoal.setFootballMatch(footballMatch.get());
        newMatchGoal.setPlayer(player.get());
        return matchGoalRepository.save(newMatchGoal);
    }

    @DeleteMapping("/matchgoals/{id}")
    @CrossOrigin(origins = "*")
    public void deleteMatchGoal(@PathVariable int id) {
        matchGoalRepository.deleteById(id);
    }
// MatchGoals end

// Seasons
    @GetMapping("/seasons")
    @CrossOrigin(origins = "*")
    public List<Season> getAllSeasons(){
        return seasonRepository.findAll();
    }

    @GetMapping("/seasons/{id}")
    @CrossOrigin(origins = "*")
    public Season getSeason(@PathVariable int id){
        Optional<Season> season = seasonRepository.findById(id);
        return season.get();
    }

    @PostMapping("/seasons")
    @CrossOrigin(origins = "*")
    public Season createSeason(@RequestBody Map<String, String> body) {
        LocalDate start_date = LocalDate.parse(body.get("start_date"));
        LocalDate end_date = LocalDate.parse(body.get("end_date"));
        String name = body.get("name");
        String description = body.get("description");
        return seasonRepository.save(new Season(start_date, end_date, name, description));
    }

    @PutMapping("/seasons/{id}")
    @CrossOrigin(origins = "*")
    public Season updateSeason(@PathVariable int id,
                                     @RequestBody Map<String, String> body) {
        Optional<Season> oldSeason = seasonRepository.findById(id);
        Season newSeason = oldSeason.get();

        newSeason.setStart_date(LocalDate.parse(body.get("start_date")));
        newSeason.setEnd_date(LocalDate.parse(body.get("end_date")));
        newSeason.setName(body.get("name"));
        newSeason.setDescription(body.get("description"));
        return seasonRepository.save(newSeason);
    }

    @DeleteMapping("/seasons/{id}")
    @CrossOrigin(origins = "*")
    public void deleteSeason(@PathVariable int id) {
        seasonRepository.deleteById(id);
    }
// Seasons end

// GoalType
    @GetMapping("/goaltypes")
    @CrossOrigin(origins = "*")
    public List<GoalType> getAllGoalTypes(){
        return goalTypeRepository.findAll();
    }

    @GetMapping("/goaltypes/{id}")
    @CrossOrigin(origins = "*")
    public GoalType getGoalType(@PathVariable int id){
        Optional<GoalType> goalType = goalTypeRepository.findById(id);
        return goalType.get();
    }

    @PostMapping("/goaltypes")
    @CrossOrigin(origins = "*")
    public GoalType createGoalType(@RequestBody Map<String, String> body) {
        String type = body.get("type");
        return goalTypeRepository.save(new GoalType(type));
    }

    @PutMapping("/goaltypes/{id}")
    @CrossOrigin(origins = "*")
    public GoalType updateGoalType(@PathVariable int id,
                               @RequestBody Map<String, String> body) {
        Optional<GoalType> oldGoalType = goalTypeRepository.findById(id);
        GoalType newGoalType = oldGoalType.get();

        newGoalType.setType(body.get("type"));
        return goalTypeRepository.save(newGoalType);
    }

    @DeleteMapping("/goaltypes/{id}")
    @CrossOrigin(origins = "*")
    public void deleteGoalType(@PathVariable int id) {
        goalTypeRepository.deleteById(id);
    }
// GoalType end

// MatchPosition
    @GetMapping("/matchpositions")
    @CrossOrigin(origins = "*")
    public List<MatchPosition> getAllMatchPositions(){
        return matchPositionRepository.findAll();
    }

    @GetMapping("/matchpositions/{playerId}/{matchId}")
    @CrossOrigin(origins = "*")
    public MatchPosition getGoalType(@PathVariable int playerId, @PathVariable int matchId){
        MatchPositionId matchPositionId = new MatchPositionId();
        matchPositionId.setPlayer(playerRepository.findById(playerId).get());
        matchPositionId.setFootballMatch(matchRepository.findById(matchId).get());

        return matchPositionRepository.findById(matchPositionId).get();
    }

    @PostMapping("/matchpositions")
    @CrossOrigin(origins = "*")
    public MatchPosition createMatchPosition(@RequestBody Map<String, String> body) {
        Player player = playerRepository.findById(Integer.parseInt(body.get("playerId"))).get();
        Match match = matchRepository.findById(Integer.parseInt(body.get("matchId"))).get();

        MatchPositionId matchPositionId = new MatchPositionId();
        matchPositionId.setPlayer(player);
        matchPositionId.setFootballMatch(match);
        String position = body.get("position");

        MatchPosition matchPosition = new MatchPosition();
        matchPosition.setPrimaryKey(matchPositionId);
        matchPosition.setPosition(position);

        return matchPositionRepository.save(matchPosition);
    }

    @PutMapping("/matchpositions/{playerId}/{matchId}")
    @CrossOrigin(origins = "*")
    public MatchPosition updateMatchPosition(@PathVariable int playerId, @PathVariable int matchId,
                                   @RequestBody Map<String, String> body) {
        Player player = playerRepository.findById(playerId).get();
        Match match = matchRepository.findById(matchId).get();
        MatchPositionId matchPositionId = new MatchPositionId();
        matchPositionId.setPlayer(player);
        matchPositionId.setFootballMatch(match);

        MatchPosition newMatchPosition = matchPositionRepository.findById(matchPositionId).get();
        newMatchPosition.setPosition(body.get("position"));

        return matchPositionRepository.save(newMatchPosition);
    }

    @DeleteMapping("/matchpositions/{playerId}/{matchId}")
    @CrossOrigin(origins = "*")
    public void deleteMatchPosition(@PathVariable int playerId, @PathVariable int matchId) {
        Player player = playerRepository.findById(playerId).get();
        Match match = matchRepository.findById(matchId).get();
        MatchPositionId matchPositionId = new MatchPositionId();
        matchPositionId.setPlayer(player);
        matchPositionId.setFootballMatch(match);
        matchPositionRepository.deleteById(matchPositionId);
    }
// MatchPosition end

// Custom endpoints
    @GetMapping("/players/team/{teamId}")
    @CrossOrigin(origins = "*")
    public List<TeamPlayersInfo> getAllTeamPlayersInfo(@PathVariable int teamId){
        List<Player> players = playerRepository.findByTeamId(teamId);
        List<TeamPlayersInfo> playerInfoList = new ArrayList<>();

        for(int i = 0; i < players.size(); i++) {
            TeamPlayersInfo info = new TeamPlayersInfo(
                    personRepository.findById(players.get(i).getPerson()).get(),
                    players.get(i)
            );
            playerInfoList.add(info);
        }
        return playerInfoList;
    }

// Helper methods
    private LocalDate parseDate(String dateString) {
        return LocalDate.parse(dateString);
    }
}
