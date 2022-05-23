insert into product values ("VRB","Vin Rouge Bordeaux",8.50,0.21);
insert into product values ("WJD","Whisky Jack Daniel's",17,0.21);
insert into product values ("GB","Gin Bombay",16,0.21);
insert into product values ("VBS","Vin Blanc Sauvignon",6,0.21);
insert into product values ("BD","Bière Duvel",2.5,0.21);

insert into locality values ("NAM50",5000,"Namur");
insert into locality values ("CHA20",6000,"Charleroi");
insert into locality values ("LIE40",4000,"Liège");
insert into locality values ("MON70",7000,"Mons");
insert into locality values ("BRU10",1000,"Bruxelles");

insert into customer values (100,"Louis","Lecire","BE23 4598 6321 9452","cash","Rue des Lilas",12,"NAM50");
insert into customer values (101,"Fred","Dupuis","BE23 4562 1112 7854","bank","Avenue Georges",8,"CHA20");
insert into customer values (102,"Louise","Marchal","BE23 8965 3658 1245","cash","Boulevard Gauchy",156,"LIE40");
insert into customer values (103,"Malek","Rajid","BE23 1235 8461 1365","cash","Avenue Prince",85,"MON70");
insert into customer values (104,"Chloe","Kuij","BE93 4682 6321 4861","bank","Avenue Louise",96,"BRU10");

insert into seller values ("JOPI18","John","Piel",'2018-12-5');
insert into seller values ("ARPR15","Arthur","Preud",'2015-10-25');
insert into seller values ("LUKL20","Luc","Klein",'2020-10-12');
insert into seller values ("PIRO21","Pierre","Roche",'2021-01-22');
insert into seller values ("SIMA12","Simon","Malte",'2012-05-01');

insert into `order` values ("015M","JOPI18","100",'2021-12-10','2021-12-15','2021-12-17','2021-12-25','2021-12-24',0,true,true,"Rue des Lilas",12,"NAM50");
insert into `order` values ("45KL","ARPR15","101",'2020-10-10','2020-10-12','2020-10-20','2021-10-17','2021-10-25',0,true,true,"Avenue Georges",8,"CHA20");
insert into `order` values ("65FB","LUKL20","102",'2020-02-19','2020-02-20','2020-02-23','2020-02-27','2021-12-24',0,false,true,"Boulevard Gauchy",156,"LIE40");
insert into `order` values ("84PM","PIRO21","103",'2019-04-08','2019-04-09','2019-04-13','2019-04-16','2019-04-20',1,false,true,"Avenue Prince",85,"MON70");
insert into `order` values ("54JI","SIMA12","104",'2021-01-08','2021-01-12','2021-01-14','2021-01-16','2021-01-16',0,true,false,"Avenue Louise",96,"BRU10");
insert into `order` values ("18DL","JOPI18","100",'2021-12-10','2021-12-15','2021-12-17','2021-12-25','2021-12-24',0,true,true,"Rue des Lilas",12,"NAM50");

insert into detail_line values ("015M","GB",NULL,10,5);
insert into detail_line values ("45KL","WJD",0.10,15.3,5);
insert into detail_line values ("65FB","GB",NULL,16,20);
insert into detail_line values ("84PM","VBS",NULL,6,10);
insert into detail_line values ("54JI","BD",0.20,2,40);
insert into detail_line values ("18DL","GB",NULL,8.50,3);