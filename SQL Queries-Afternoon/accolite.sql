CREATE DATABASE world_cup;

/*DROP DATABASE world_cup;*/
USE world_cup;

CREATE TABLE Matches(matchid INT NOT NULL,country1 VARCHAR(100), country2 VARCHAR(100), PRIMARY KEY(matchid));

/*DROP TABLE Matches;*/

INSERT INTO Matches(matchid,country1,country2)
VALUES(15,'PAKISTAN','INDIA');
INSERT INTO Matches(matchid,country1,country2)
VALUES(10,'NEW ZEALAND','INDIA');
INSERT INTO Matches(matchid,country1,country2)
VALUES(20,'NEW ZEALAND','PAKISTAN');
INSERT INTO Matches(matchid,country1,country2)
VALUES(8,'ENGLAND','INDIA');
INSERT INTO Matches(matchid,country1,country2)
VALUES(12,'INDIA','AUSTRALIA');

SELECT * FROM Matches;

CREATE TABLE Players(playerid INT NOT NULL UNIQUE, playername VARCHAR(100) NOT NULL, country VARCHAR(100) NOT NULL, category VARCHAR(50) NOT NULL, PRIMARY KEY(playerid));

/*DROP TABLE Players;*/

INSERT INTO Players(playerid,playername,country,category)
VALUES(1,'Virat Kohli','INDIA','Batsman');

INSERT INTO Players(playerid,playername,country,category)
VALUES(2,'Rohit Sharma','INDIA','Batsman');

INSERT INTO Players(playerid,playername,country,category)
VALUES(3,'Kane Williamson','NEW ZEALAND','Batsman');

INSERT INTO Players(playerid,playername,country,category)
VALUES(4,'Saeed Ajmal','PAKISTAN','Bowler');

INSERT INTO Players(playerid,playername,country,category)
VALUES(5,'M.S. Dhoni','INDIA','Batsman');

INSERT INTO Players(playerid,playername,country,category)
VALUES(6,'Joe Root','ENGLAND','Bowler');

INSERT INTO Players(playerid,playername,country,category)
VALUES(7,'David Warner','AUSTRALIA','Batsman');

INSERT INTO Players(playerid,playername,country,category)
VALUES(8,'Chris Woakes','ENGLAND','Bowler');

INSERT INTO Players(playerid,playername,country,category)
VALUES(9,'Eoin Morgan','AUSTRALIA','Batsman');

INSERT INTO Players(playerid,playername,country,category)
VALUES(10,'Trent Boult','NEW ZEALAND','Bowler');

INSERT INTO Players(playerid,playername,country,category)
VALUES(11,'Shahid Afridi','PAKISTAN','Batsman');

INSERT INTO Players(playerid,playername,country,category)
VALUES(12,'Jason Roy','ENGLAND','Batsman');

SELECT * FROM Players;

CREATE TABLE Scores(playerid INT NOT NULL, matchid INT NOT NULL, runs INT, wickets INT, PRIMARY KEY(playerid, matchid));

/*DROP TABLE Scores;*/

INSERT INTO Scores(playerid,matchid,runs,wickets) 
VALUES (1,10,50,1);
INSERT INTO Scores(playerid,matchid,runs,wickets) 
VALUES (4,20,20,1);
INSERT INTO Scores(playerid,matchid,runs,wickets) 
VALUES (3,10,100,1);
INSERT INTO Scores(playerid,matchid,runs,wickets) 
VALUES (1,12,17,0);
INSERT INTO Scores(playerid,matchid,runs,wickets) 
VALUES (2,10,30,1);
INSERT INTO Scores(playerid,matchid,runs,wickets) 
VALUES (3,20,80,0);
INSERT INTO Scores(playerid,matchid,runs,wickets) 
VALUES (11,15,10,1);
INSERT INTO Scores(playerid,matchid,runs,wickets) 
VALUES (1,15,90,0);
INSERT INTO Scores(playerid,matchid,runs,wickets) 
VALUES (2,15,70,0);
INSERT INTO Scores(playerid,matchid,runs,wickets) 
VALUES (4,15,25,0);
INSERT INTO Scores(playerid,matchid,runs,wickets) 
VALUES (5,15,10,2);
INSERT INTO Scores(playerid,matchid,runs,wickets) 
VALUES (5,10,40,0);
INSERT INTO Scores(playerid,matchid,runs,wickets) 
VALUES (10,10,30,1);
INSERT INTO Scores(playerid,matchid,runs,wickets) 
VALUES (10,20,12,1);
INSERT INTO Scores(playerid,matchid,runs,wickets) 
VALUES (11,20,46,0);
INSERT INTO Scores(playerid,matchid,runs,wickets) 
VALUES (6,8,28,1);
INSERT INTO Scores(playerid,matchid,runs,wickets) 
VALUES (8,8,32,0);
INSERT INTO Scores(playerid,matchid,runs,wickets) 
VALUES (12,8,29,0);
INSERT INTO Scores(playerid,matchid,runs,wickets) 
VALUES (1,8,48,0);
INSERT INTO Scores(playerid,matchid,runs,wickets) 
VALUES (2,8,33,0);
INSERT INTO Scores(playerid,matchid,runs,wickets) 
VALUES (5,8,16,2);
INSERT INTO Scores(playerid,matchid,runs,wickets) 
VALUES (2,12,11,2);
INSERT INTO Scores(playerid,matchid,runs,wickets) 
VALUES (5,12,63,0);
INSERT INTO Scores(playerid,matchid,runs,wickets) 
VALUES (7,12,50,0);
INSERT INTO Scores(playerid,matchid,runs,wickets) 
VALUES (9,12,48,1);

SELECT * FROM Scores;

/*Query1*/
SELECT s.playerid,p.playername,p.country, SUM(runs)
FROM Scores s
INNER JOIN Players p
ON s.playerid=p.playerid 
GROUP BY s.playerid
ORDER BY SUM(runs) DESC LIMIT 5;

/*Query2*/
SELECT s.playerid,p.playername,p.country,SUM(wickets) 
FROM Scores s
INNER JOIN Players p
ON s.playerid=p.playerid
GROUP BY s.playerid
ORDER BY SUM(wickets) DESC LIMIT 5;

/*Query3*/
SELECT p.country, SUM(runs)/COUNT(DISTINCT s.matchid) AS Average_Score
FROM Players p
INNER JOIN Scores s
ON s.playerid=p.playerid
INNER JOIN Matches m
ON s.matchid=m.matchid
GROUP BY p.country;

/*Query4*/
SELECT p.playerid, s.runs,p.country
FROM Players p
INNER JOIN Scores s
ON p.playerid =s.playerid
WHERE s.runs>(
SELECT SUM(runs)/COUNT(DISTINCT s.matchid) AS Average_Score
FROM Players p
INNER JOIN Scores s
ON s.playerid=p.playerid
INNER JOIN Matches m
ON s.matchid=m.matchid
GROUP BY p.country
ORDER BY Average_Score LIMIT 1);


/*Query5*/
SET SQL_SAFE_UPDATES = 0;

UPDATE Scores
INNER JOIN Players
ON Scores.playerid =Players.playerid
SET runs=runs+10
WHERE category='Batsman' AND country = (
SELECT * FROM
(SELECT p.country AS country
FROM Players p
INNER JOIN Scores s
ON s.playerid=p.playerid
INNER JOIN Matches m
ON s.matchid=m.matchid
GROUP BY p.country
ORDER BY SUM(runs)/COUNT(DISTINCT s.matchid) LIMIT 1)tbltmp);

SET SQL_SAFE_UPDATES = 1;



/*Query6*/
DELIMITER $$

DROP PROCEDURE IF EXISTS CountryHighestScore$$
CREATE PROCEDURE CountryHighestScore(country VARCHAR(100), OUT highscore INT)
BEGIN
SELECT SUM(s.runs) INTO highscore
FROM Players p
INNER JOIN Scores s
ON p.playerid = s.playerid
INNER JOIN Matches m
ON s.matchid = m.matchid
WHERE p.country = country  
GROUP BY m.matchid
ORDER BY SUM(s.runs) DESC LIMIT 1;
END$$

DELIMITER ;END$$

DELIMITER ;
CALL CountryHighestScore('INDIA',@highscore);
SELECT @highscore;

CALL CountryHighestScore('NEW ZEALAND',@highscore);
SELECT @highscore;