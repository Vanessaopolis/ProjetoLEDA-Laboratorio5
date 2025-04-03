import random

# 1000 primeiros nomes únicos
primeiros_nomes = ['Abel', 'Abelardo', 'Abilio', 'Abraao', 'Abrahao', 'Abrao', 'Ada', 'Adalberto', 'Adalgisa', 'Adao',
                   'Adela', 'Adelaide', 'Adelberto', 'Adele', 'Adelia', 'Adelina', 'Ademar', 'Adhemar', 'Adolfo',
                   'Adolpho', 'Adrian', 'Adriana', 'Adriane', 'Adrianne', 'Adriano', 'Adriene', 'Adrienne', 'Afonso',
                   'Agata', 'Agatha', 'Agenor', 'Agnaldo', 'Agnes', 'Agostinho', 'Aguinaldo', 'Aida', 'Aiko', 'Ailton',
                   'Aimee', 'Airton', 'Ajit', 'Akahana', 'Akako', 'Alaide', 'Alana', 'Alane', 'Alanna', 'Alanne',
                   'Alba', 'Alberta', 'Albertina', 'Alberto', 'Alceu', 'Alcides', 'Alcione', 'Alcyone', 'Alda',
                   'Aldaberto', 'Aldine', 'Aldo', 'Alec', 'Alecsandra', 'Alegra', 'Alejandra', 'Aleksandra',
                   'Alessandra', 'Alessandro', 'Alex', 'Alexandra', 'Alexandre', 'Alexis', 'Alfonso', 'Alfredo',
                   'Alice', 'Alicia', 'Alisha', 'Allegra', 'Aloisio', 'Alonso', 'Aluisio', 'Alvaro', 'Alzira', 'Amadeu',
                   'Amadeus', 'Amalia', 'Amanda', 'Amar', 'Amauri', 'Amaury', 'Amedeo', 'Amelia', 'Amelie', 'America',
                   'Americo', 'Amilcar', 'Amisha', 'Amita', 'Amiti', 'Amy', 'Ana', 'Anais', 'Anastacia', 'Anastasia',
                   'Andre', 'Andrea', 'Andreia', 'Andresa', 'Andressa', 'Andreza', 'Andrezza', 'Anete', 'Angel',
                   'Angela', 'Angeli', 'Angelica', 'Angelina', 'Angelita', 'Angelo', 'Anibal', 'Anisio', 'Anita',
                   'Anna', 'Anne', 'Annete', 'Anoush', 'Anselmo', 'Antenor', 'Antonela', 'Antonella', 'Antonia',
                   'Antonieta', 'Antonio', 'Aparecida', 'Aquiles', 'Araci', 'Aracy', 'Areta', 'Aretha', 'Ariana',
                   'Ariane', 'Ariela', 'Ariella', 'Arielle', 'Arlene', 'Arlete', 'Armando', 'Arnaldo', 'Arthur',
                   'Artur', 'Asha', 'Assuncao', 'Astrid', 'Astride', 'Ataulfo', 'Augusta', 'Augustina', 'Augustine',
                   'Augusto', 'Aurelia', 'Aurelio', 'Auro', 'Aurora', 'Auxiliadora', 'Ayrton', 'Ayumi', 'Babette',
                   'Balbina', 'Balraj', 'Baltazar', 'Barbara', 'Barbie', 'Barbra', 'Bartolomeu', 'Basilio', 'Beata',
                   'Beatrice', 'Beatrix', 'Beatriz', 'Bela', 'Belinda', 'Bella', 'Belle', 'Benedicta', 'Benedicto',
                   'Benedita', 'Benedito', 'Benicio', 'Benito', 'Benjamim', 'Benjamin', 'Bento', 'Berenice',
                   'Bernadete', 'Bernadette', 'Bernarda', 'Bernardino', 'Bernardo', 'Berta', 'Bertha', 'Betania',
                   'Bete', 'Beth', 'Betina', 'Bianca', 'Biatriz', 'Blanche', 'Boris', 'Branca', 'Brenda', 'Breno',
                   'Briana', 'Brianne', 'Bridget', 'Brigida', 'Brigite', 'Brigitte', 'Brione', 'Bruna', 'Brunete',
                   'Bruno', 'Cacilda', 'Caetano', 'Caio', 'Calista', 'Calixta', 'Calixto', 'Camelia', 'Camellia',
                   'Cameron', 'Camila', 'Camile', 'Camilla', 'Camille', 'Camilo', 'Candice', 'Candida', 'Candido',
                   'Capitu', 'Carina', 'Carine', 'Carla', 'Carlo', 'Carlos', 'Carlota', 'Carmel', 'Carmela',
                   'Carmelita', 'Carmem', 'Carmen', 'Carmina', 'Carmo', 'Carol', 'Carola', 'Carolina', 'Caroline',
                   'Carolyn', 'Carolyne', 'Cassandra', 'Cassia', 'Cassiano', 'Cassilda', 'Cassio', 'Catarina',
                   'Caterina', 'Catherine', 'Cecile', 'Cecilia', 'Celeste', 'Celia', 'Celina', 'Celine', 'Celio',
                   'Celso', 'Ceres', 'Cesar', 'Chandra', 'Charles', 'Charlotte', 'Chelsea', 'Chiara', 'Chloe',
                   'Christal', 'Christian', 'Christiana', 'Christiane', 'Christina', 'Christopher', 'Chrystal',
                   'Cibele', 'Cicero', 'Cilene', 'Cinthia', 'Cintia', 'Ciro', 'Clair', 'Claire', 'Clara', 'Clarice',
                   'Clarissa', 'Clarisse', 'Claudete', 'Claudette', 'Claudia', 'Claudio', 'Cleide', 'Clelia', 'Cleusa',
                   'Cloe', 'Clotilda', 'Clotilde', 'Clotildes', 'Conceicao', 'Conrado', 'Consuelo', 'Cora', 'Cordelia',
                   'Corina', 'Cornelia', 'Cosette', 'Creusa', 'Creuza', 'Cristal', 'Cristiana', 'Cristiane',
                   'Cristiano', 'Cristina', 'Cristovao', 'Cynthia', 'Cyntia', 'Dafne', 'Dagmar', 'Dagmara', 'Daiana',
                   'Daiane', 'Daisy', 'Dalia', 'Dalila', 'Dalton', 'Dalva', 'Damiao', 'Dana', 'Daniel', 'Daniela',
                   'Daniele', 'Daniella', 'Danielle', 'Danilo', 'Dante', 'Daphne', 'Dara', 'Darci', 'Darcy', 'Daria',
                   'Dario', 'Darlene', 'Davi', 'David', 'Daya', 'Debora', 'Deborah', 'Decio', 'Deepak', 'Deise',
                   'Delfina', 'Delia', 'Demi', 'Denice', 'Denis', 'Denise', 'Desiree', 'Deva', 'Devi', 'Dhara', 'Diana',
                   'Diane', 'Diego', 'Dina', 'Dinah', 'Diogo', 'Dione', 'Dionise', 'Dipak', 'Dirce', 'Dirceu', 'Diva',
                   'Djalma', 'Djane', 'Dolores', 'Dominique', 'Donata', 'Dora', 'Doralice', 'Doris', 'Dorotea',
                   'Doroteia', 'Dorothy', 'Dulce', 'Dulcinea', 'Dulcineia', 'Eder', 'Edgar', 'Edison', 'Edite', 'Edith',
                   'Edmundo', 'Edna', 'Edson', 'Eduardo', 'Elaine', 'Elba', 'Elenice', 'Eleonor', 'Eleonora', 'Eliana',
                   'Eliane', 'Elias', 'Elio', 'Elis', 'Elisa', 'Elisabete', 'Elisabeth', 'Eliseu', 'Eliza', 'Elizabete',
                   'Elizabeth', 'Eloa', 'Eloah', 'Eloisa', 'Elsa', 'Elvira', 'Elvis', 'Elza', 'Elzira', 'Ema',
                   'Emanuel', 'Emanuela', 'Emanuele', 'Emanuelle', 'Emerson', 'Emilia', 'Emilio', 'Emily', 'Emma',
                   'Enrico', 'Enrique', 'Enzo', 'Erasmo', 'Eric', 'Erica', 'Erico', 'Erika', 'Eriko', 'Ernesto',
                   'Esmeralda', 'Esperanca', 'Estefano', 'Estela', 'Ester', 'Estevao', 'Esther', 'Eugenia', 'Eugenio',
                   'Eunice', 'Eva', 'Evandro', 'Evangelina', 'Eve', 'Evelin', 'Evelina', 'Eveline', 'Evelyn', 'Fabia',
                   'Fabiana', 'Fabiano', 'Fabio', 'Fabiola', 'Fabricia', 'Fabricio', 'Fabrizio', 'Fanny', 'Fatima',
                   'Fausta', 'Faustina', 'Fausto', 'Felicia', 'Felicio', 'Felipa', 'Felipe', 'Felix', 'Ferdinando',
                   'Fernanda', 'Fernando', 'Fernao', 'Filipa', 'Filipe', 'Filippo', 'Filomena', 'Fiona', 'Flavia',
                   'Flavio', 'Flor', 'Flora', 'Franca', 'Frances', 'Francesca', 'Francesco', 'Francine', 'Francis',
                   'Francisca', 'Francisco', 'Francoise', 'Frederico', 'Frida', 'Gabriel', 'Gabriela', 'Gabriele',
                   'Gabriella', 'Gabrielle', 'Gaetano', 'Ganesh', 'Genji', 'George', 'Georgia', 'Georgiana', 'Georgina',
                   'Geralda', 'Geraldo', 'Germano', 'Gerson', 'Gertrude', 'Gertrudes', 'Gervasio', 'Giancarlo',
                   'Gilberto', 'Gilda', 'Gilmar', 'Gilmara', 'Gilson', 'Gina', 'Gioconda', 'Giorgio', 'Giovana',
                   'Giovanna', 'Giovanni', 'Gisela', 'Giselda', 'Gisele', 'Gisella', 'Giselle', 'Gita', 'Giulia',
                   'Gizelda', 'Gladis', 'Gladys', 'Glauber', 'Glauce', 'Glaucia', 'Glauco', 'Glenda', 'Gloria',
                   'Goncalo', 'Gonzalo', 'Graca', 'Grace', 'Graziela', 'Gregorio', 'Greice', 'Greta', 'Gretchen',
                   'Gualter', 'Guilherme', 'Guiomar', 'Gunther', 'Gustavo', 'Gyselle', 'Hadrian', 'Haide', 'Haidee',
                   'Halima', 'Hamilton', 'Hannah', 'Hayde', 'Hebe', 'Hector', 'Heidi', 'Heitor', 'Helena', 'Helenice',
                   'Helga', 'Helio', 'Heloisa', 'Henrique', 'Henriqueta', 'Henry', 'Herculano', 'Hilda', 'Hildegard',
                   'Homero', 'Horacio', 'Horishi', 'Hortensia', 'Hugo', 'Humberto', 'Iara', 'Icaro', 'Idalina', 'Ieda',
                   'Iemanja', 'Ignacio', 'Igor', 'Ilsa', 'Inacio', 'Indra', 'Ines', 'Inez', 'Ingrid', 'Ingride',
                   'Iolanda', 'Iona', 'Ione', 'Iracema', 'Irene', 'Irina', 'Iris', 'Isa', 'Isaac', 'Isabel', 'Isabela',
                   'Isabele', 'Isabella', 'Isabelle', 'Isadora', 'Isaias', 'Isaura', 'Isidora', 'Isidoro', 'Isis',
                   'Ismael', 'Israel', 'Italo', 'Itamar', 'Iuri', 'Iva', 'Ivan', 'Ivete', 'Ivette', 'Ivo', 'Ivone',
                   'Ivonne', 'Izabela', 'Jaci', 'Jacira', 'Jaco', 'Jacob', 'Jacqueline', 'Jacques', 'Jacy', 'Jacyra',
                   'Jade', 'Jaime', 'Jair', 'Jairo', 'Jamal', 'Jamil', 'Jamila', 'Janaina', 'Jandir', 'Jandira',
                   'Jandyr', 'Jandyra', 'Jane', 'Janete', 'Janice', 'Jaqueline', 'Jasmim', 'Jasmin', 'Jasmina',
                   'Jasmine', 'Jean', 'Jefferson', 'Jeni', 'Jenifer', 'Jennifer', 'Jenny', 'Jeremias', 'Jessica', 'Jin',
                   'Joana', 'Joanna', 'Joao', 'Joaquim', 'Joaquina', 'Joel', 'Joelle', 'Jonas', 'Jonatan', 'Jonatas',
                   'Jonathan', 'Jordana', 'Jordao', 'Jorge', 'Jose', 'Josefina', 'Josephine', 'Josias', 'Joy', 'Juarez',
                   'Judite', 'Judith', 'Julia', 'Juliana', 'Juliano', 'Julieta', 'Julio', 'Junior', 'Jussara',
                   'Justina', 'Justino', 'Kaila', 'Kaio', 'Kalil', 'Kalila', 'Kaori', 'Karen', 'Karim', 'Karina',
                   'Karine', 'Karla', 'Karoline', 'Kassia', 'Kate', 'Katerine', 'Katharina', 'Katherine', 'Katia',
                   'Katya', 'Keiko', 'Keila', 'Keith', 'Kelly', 'Kelvin', 'Kesia', 'Khalil', 'Kim', 'Kin', 'Kristal',
                   'Kyoko', 'Laercio', 'Laerte', 'Laila', 'Lailah', 'Lais', 'Laisa', 'Lana', 'Lara', 'Larisa',
                   'Larissa', 'Lateefah', 'Latifa', 'Latiffa', 'Laura', 'Lauro', 'Lavinia', 'Layla', 'Lazaro', 'Lea',
                   'Leandra', 'Leandro', 'Leda', 'Leia', 'Leila', 'Leilah', 'Lenora', 'Leon', 'Leona', 'Leonardo',
                   'Leonidas', 'Leonor', 'Leonora', 'Leopoldo', 'Leticia', 'Letizia', 'Li', 'Lia', 'Lidia', 'Lien',
                   'Ligia', 'Lila', 'Lilia', 'Lilian', 'Liliana', 'Liliane', 'Lina', 'Linda', 'Lindsay', 'Linete',
                   'Linette', 'Lineu', 'Lisa', 'Lisandra', 'Lisandro', 'Livia', 'Livio', 'Liza', 'Lizandra', 'Lizandro',
                   'Lola', 'Lorelei', 'Lorena', 'Lorenzo', 'Loreta', 'Lourdes', 'Lourenco', 'Luana', 'Luca', 'Lucas',
                   'Luci', 'Lucia', 'Luciana', 'Luciane', 'Luciano', 'Luciene', 'Lucila', 'Lucio', 'Lucy', 'Ludemila',
                   'Ludmila', 'Luigi', 'Luis', 'Luisa', 'Luiz', 'Luiza', 'Luna', 'Lurdes', 'Luzia', 'Lydia', 'Lynn',
                   'Mabel', 'Madalena', 'Mafalda', 'Magali', 'Magda', 'Magdalena', 'Magno', 'Maia', 'Maiara', 'Maira',
                   'Maisa', 'Maite', 'Malika', 'Manoel', 'Manoela', 'Manu', 'Manuel', 'Manuela', 'Manuelle', 'Maome',
                   'Mara', 'Marcel', 'Marcela', 'Marcele', 'Marcella', 'Marcello', 'Marcelo', 'Marcia', 'Marcio',
                   'Marco', 'Marcos', 'Margarida', 'Margarita', 'Margot', 'Maria', 'Mariah', 'Mariana', 'Mariangela',
                   'Marianne', 'Mariano', 'Marilia', 'Marina', 'Mario', 'Marisa', 'Marise', 'Mariza', 'Marize',
                   'Marjorie', 'Marlene', 'Marli', 'Marly', 'Marta', 'Martha', 'Martim', 'Martina', 'Marvin', 'Mary',
                   'Masculino', 'Mateus', 'Matheus', 'Mathias', 'Matias', 'Matilda', 'Matilde', 'Maura', 'Mauricio',
                   'Mauro', 'Maya', 'Mayara', 'Mayra', 'Maysa', 'Megan', 'Meire', 'Melinda', 'Melissa', 'Melvin',
                   'Messias', 'Micael', 'Michaela', 'Michaella', 'Michel', 'Michele', 'Michelle', 'Midori', 'Miguel',
                   'Mika', 'Mildred', 'Milena', 'Milton', 'Mingmei', 'Miranda', 'Miriam', 'Mirian', 'Mirna', 'Miyoko',
                   'Moema', 'Moira', 'Moises', 'Monica', 'Monique', 'Moyses', 'Mozart', 'Muriel', 'Murilo', 'Nadia',
                   'Nadine', 'Nadir', 'Nadya', 'Naila', 'Nailah', 'Nair', 'Najma', 'Nancy', 'Naomi', 'Napoleao', 'Nara',
                   'Narcisa', 'Narciso', 'Natacha', 'Natalia', 'Natalie', 'Natanael', 'Nataniel', 'Natasha', 'Nathalia',
                   'Nathanael', 'Nayana', 'Nazare', 'Nei', 'Neide', 'Nelson', 'Nereu', 'Nestor', 'Neusa', 'Ney', 'Nice',
                   'Nicholas', 'Nicolas', 'Nicolau', 'Nicole', 'Nika', 'Nilse', 'Nilson', 'Nilton', 'Nilza', 'Nina',
                   'Nisha', 'Nivea', 'Nivia', 'Noel', 'Noemi', 'Noemia', 'Nora', 'Norah', 'Norberto', 'Norma', 'Norton',
                   'Nuno', 'Octavia', 'Octavio', 'Odete', 'Odette', 'Odila'
                   ]
print(f"primeiros nomes: {len(primeiros_nomes)}, primeiros nomes únicos: {len(set(primeiros_nomes))}\n")

# 840 sobrenomes únicos
sobrenomes = ['Abadia', 'Abilio', 'Abrantes', 'Abreu', 'Abud', 'Acosta', 'Adorno', 'Afif', 'Afonso', 'Agostini',
              'Aguiar', 'Aguilar', 'Aguirre', 'Aita', 'Albuquerque', 'Alcantara', 'Alderighi', 'Aleixo', 'Alencar',
              'Alexio', 'Alfano', 'Almeida', 'Alvarenga', 'Alves', 'Alvim', 'Amaral', 'Amato', 'Ambrizzi', 'Ambrosio',
              'Americo', 'Amorim', 'Anastacio', 'Anastasio', 'Andrade', 'Andrea', 'Andrioli', 'Angelis', 'Angelo',
              'Anjos', 'Antico', 'Antonioli', 'Antunes', 'Aparecido', 'Aponte', 'Aquino', 'Aragao', 'Arantes', 'Araujo',
              'Arbex', 'Arcanjo', 'Arcari', 'Archangelo', 'Argolo', 'Armentano', 'Arnaud', 'Arouca', 'Arrighi',
              'Arrigo', 'Arruda', 'Assaf', 'Assis', 'Assumpcao', 'Athayde', 'Aucelio', 'Aureliano', 'Avelar', 'Avelino',
              'Azambuja', 'Bacchi', 'Bacci', 'Bacelar', 'Baggio', 'Baiocchi', 'Baldini', 'Balduino', 'Ballester',
              'Baltar', 'Bandini', 'Barbosa', 'Barbugiani', 'Barcala', 'Barcelli', 'Barcellos', 'Bardeira', 'Barduco',
              'Barella', 'Bariani', 'Barreto', 'Barros', 'Bartolomeu', 'Basilio', 'Bassetti', 'Basso', 'Bastos',
              'Batista', 'Bazzo', 'Becari', 'Beccari', 'Belchior', 'Belfort', 'Belini', 'Bellan', 'Belmonte',
              'Benedetti', 'Benedito', 'Beneduce', 'Benevides', 'Benini', 'Benitez', 'Benvenuto', 'Beraldo',
              'Bernardes', 'Bertolini', 'Bezerra', 'Biancardi', 'Bianchi', 'Bianchini', 'Biasotto', 'Biazi', 'Bibiano',
              'Bicalho', 'Biffi', 'Biselli', 'Bitelli', 'Bittencourt', 'Boaventura', 'Bocchi', 'Boccia', 'Bodanese',
              'Boff', 'Bolzan', 'Bonaccorsi', 'Bonaccorso', 'Bonacorsi', 'Bonato', 'Bonatti', 'Bonfim', 'Bonini',
              'Bonizio', 'Bononi', 'Borba', 'Borelli', 'Borges', 'Bortolacci', 'Bortolato', 'Bortoluzzi', 'Botelho',
              'Botta', 'Braga', 'Braganca', 'Braghiroli', 'Brancalion', 'Brancatti', 'Brandao', 'Brandt', 'Branquinho',
              'Bravim', 'Bravin', 'Braz', 'Bressan', 'Brianezi', 'Brites', 'Brito', 'Brochado', 'Brognoli', 'Brolo',
              'Bucci', 'Bueno', 'Bugiato', 'Buonafina', 'Buosi', 'Bussab', 'Bussolaro', 'Cabizuca', 'Cabral',
              'Cabreira', 'Caetano', 'Caires', 'Cajueiro', 'Calado', 'Calazans', 'Caldeira', 'Calijuri', 'Calil',
              'Calixto', 'Calsavara', 'Calvo', 'Camargo', 'Camatta', 'Camilo', 'Campagnolo', 'Campi', 'Campos',
              'Camposano', 'Cancellier', 'Cancellieri', 'Candido', 'Canedo', 'Cantarelli', 'Caparroz', 'Capelli',
              'Capobianco', 'Capucho', 'Caputo', 'Caram', 'Caravieri', 'Carbone', 'Carboni', 'Cardarelli', 'Cardoso',
              'Cardozo', 'Carlucci', 'Carneiro', 'Carrano', 'Caruso', 'Carvalho', 'Casanova', 'Cascardo', 'Caser',
              'Cassol', 'Castagna', 'Castellani', 'Castello', 'Castilho', 'Castro', 'Catapani', 'Catelani', 'Catuzzo',
              'Cavalcante', 'Cavalcanti', 'Cavallaro', 'Cavazza', 'Cavichioli', 'Cazzolla', 'Cecatto', 'Celani',
              'Cembranelli', 'Cereda', 'Cerqueira', 'Cerutti', 'Cervantes', 'Cesarino', 'Cesario', 'Cestari', 'Cestaro',
              'Cezar', 'Chagas', 'Chamma', 'Chamon', 'Charone', 'Chaves', 'Chiaparini', 'Chiaradia', 'Chiavone',
              'Ciciliato', 'Cimini', 'Cintra', 'Cioffi', 'Cione', 'Cipolla', 'Cipriani', 'Cirino', 'Clivati', 'Coan',
              'Coelho', 'Colares', 'Colasanti', 'Colauto', 'Colletti', 'Colodetti', 'Colombo', 'Colturato', 'Comarella',
              'Comin', 'Conceicao', 'Conrado', 'Conti', 'Contini', 'Copolla', 'Coradini', 'Corbucci', 'Cordeiro',
              'Cordovil', 'Coretti', 'Corradini', 'Correa', 'Correia', 'Corsini', 'Cortes', 'Cortese', 'Cortez',
              'Costa', 'Costacurta', 'Costeira', 'Cotrim', 'Coutinho', 'Couto', 'Cravari', 'Crema', 'Crespo',
              'Cristaldo', 'Cristofolini', 'Croce', 'Cruz', 'Cruzeta', 'Cucco', 'Cunha', 'Cuniali', 'Dalcol', 'Dalfovo',
              'Dalla', 'Dalmazo', 'Damas', 'Damasceno', 'Daminelli', 'Dantas', 'DeLazzari', 'DeMarco', 'DeMello',
              'DeNadai', 'DePieri', 'Degani', 'Delai', 'Delfino', 'Delgado', 'Deliberali', 'Demarche', 'Destro',
              'Dias', 'Dib', 'Diglio', 'Diniz', 'Diogo', 'Dolci', 'Domenico', 'Dominato', 'Domingues', 'Donadelli',
              'Donatelli', 'Doninelli', 'Dornas', 'Dorneles', 'Drummond', 'Drumond', 'Duarte', 'Dubeux', 'Duraes',
              'Dutra', 'Ebner', 'Eichler', 'Eichstaedt', 'Eidt', 'Elias', 'Eliziario', 'Encinas', 'Ennes', 'Escobar',
              'Espina', 'Espindola', 'Esposito', 'Estevao', 'Esteves', 'Evangelista', 'Evangelisti', 'Fabene', 'Fabri',
              'Fabrini', 'Facchini', 'Facci', 'Falcao', 'Falco', 'Falsetti', 'Fantin', 'Fantini', 'Fanzone', 'Faria',
              'Farias', 'Faro', 'Fasano', 'Favali', 'Favaro', 'Feitosa', 'Felicio', 'Felisberto', 'Felix', 'Fellipe',
              'Felski', 'Fernandes', 'Fernandez', 'Ferrante', 'Ferrari', 'Ferraz', 'Ferreira', 'Ferri', 'Fiamenghi',
              'Fiamoncini', 'Ficarelli', 'Figueira', 'Figueiredo', 'Figueiro', 'Figueiroa', 'Filgueira', 'Fincatti',
              'Fior', 'Fioravante', 'Fiorelli', 'Fiorentino', 'Fioretti', 'Fiorin', 'Fiorotto', 'Fleury', 'Florentino',
              'Flores', 'Florio', 'Fonseca', 'Fonsechi', 'Fontoura', 'Fortes', 'Fossa', 'Fragoso', 'Franco', 'Franzin',
              'Frasson', 'Freire', 'Freitas', 'Froelich', 'Frossard', 'Frota', 'Fugimoto', 'Furlan', 'Furlanetto',
              'Furtado', 'Gabardo', 'Gabbardo', 'Gadelha', 'Galeano', 'Galera', 'Galetti', 'Galhardo', 'Galiano',
              'Gallucci', 'Galvao', 'Gambini', 'Garbelotto', 'Garcia', 'Garnica', 'Garone', 'Garrido', 'Garzon',
              'Gaspar', 'Gasparini', 'Gasques', 'Gattei', 'Gehlen', 'Gelli', 'Gentil', 'Geraldes', 'Geremias',
              'Germani', 'Germano', 'Gianasi', 'Giangrande', 'Giannini', 'Giassi', 'Gibin', 'Giorgetti', 'Giovanetti',
              'Giovani', 'Giovanini', 'Girolami', 'Girotti', 'Giuliani', 'Gobbi', 'Gobetti', 'Goldfarb', 'Gomes', 'Gon',
              'Goncalves', 'Gorayeb', 'Gorgulho', 'Gorini', 'Goulart', 'Graciano', 'Grandini', 'Grassi', 'Graziani',
              'Grecco', 'Gregori', 'Grellet', 'Grotti', 'Gruber', 'Gualberto', 'Guardiano', 'Guastavino', 'Guedes',
              'Guerra', 'Guim', 'Guimaraes', 'Gullo', 'Gusmao', 'Guzzo', 'Habech', 'Haddad', 'Haidar', 'Hajjar',
              'Hargreaves', 'Henrique', 'Henriques', 'Heringer', 'Herkenhoff', 'Hertzog', 'Hetzl', 'Hidalgo',
              'Hiromoto', 'Hoffman', 'Hoffmann', 'Holanda', 'Holtz', 'Holzmann', 'Horacio', 'Hosokawa', 'Hummel',
              'Iannace', 'Iannuzzi', 'Iglesias', 'Ignacio', 'Imagawa', 'Imai', 'Imperatori', 'Inacio', 'Iori', 'Ito',
              'Itokazu', 'Iwahara', 'Iwasaki', 'Jabor', 'Jafet', 'Jannuzi', 'Januario', 'Jardim', 'Jardini', 'Jatoba',
              'Joffily', 'Joppert', 'Joubert', 'Junqueira', 'Jurado', 'Justino', 'Justus', 'Kalil', 'Kamei',
              'Kanashiro', 'Kaneko', 'Kanno', 'Karam', 'Kato', 'Kawamura', 'Kawanishi', 'Kawasaki', 'Kawashima',
              'Keler', 'Keppler', 'Kiyomura', 'Klein', 'Kochi', 'Kohler', 'Kondo', 'Kosaka', 'Koyama', 'Kremer',
              'Kusano', 'Kuwabara', 'Lacerda', 'Lacroix', 'Laender', 'Lafeta', 'Lage', 'Lago', 'Laibida', 'Laino',
              'Lamaita', 'Lanari', 'Lapastini', 'Lara', 'Laredo', 'Larroque', 'Latuf', 'Lauffer', 'Lazarini', 'Lazzari',
              'Lazzarini', 'Leal', 'Leandri', 'Leardini', 'Leitao', 'Leite', 'Lemos', 'Leobet', 'Lessa', 'Levorato',
              'Lima', 'Lins', 'Lobo', 'Lombardi', 'Lombardo', 'Lopes', 'Lorenzetti', 'Lourenco', 'Lucas', 'Lucchesi',
              'Luchesi', 'Luna', 'Macedo', 'Machado', 'Maciel', 'Magalhaes', 'Magini', 'Magnani', 'Maia', 'Malaguti',
              'Malheiros', 'Malta', 'Maltaca', 'Manfredini', 'Mansur', 'Mantovani', 'Marchetti', 'Marcolino', 'Maretti',
              'Marinho', 'Mariotto', 'Marques', 'Marquesi', 'Martignago', 'Martins', 'Mascarenhas', 'Masi', 'Masson',
              'Matos', 'Mattei', 'Mazza', 'Meccia', 'Medeiros', 'Medina', 'Meireles', 'Mello', 'Mendes', 'Meneghin',
              'Menezes', 'Mesquita', 'Messina', 'Michelini', 'Milani', 'Miquelin', 'Modenezi', 'Modesto', 'Molina',
              'Montanari', 'Montanha', 'Montanher', 'Monteiro', 'Montes', 'Monteverde', 'Moraes', 'Moreira', 'Moretto',
              'Moroni', 'Moura', 'Muniz', 'Nascimento', 'Nassif', 'Negrao', 'Negrini', 'Neves', 'Nishimura', 'Nogueira',
              'Noronha', 'Novaes', 'Nunes', 'Odone', 'Oliani', 'Oliveira', 'Ortega', 'Ortolani', 'Otoni', 'Ottaviano',
              'Pacheco', 'Padilha', 'Paes', 'Pagotto', 'Paim', 'Paiva', 'Paladino', 'Palmieri', 'Paoletti', 'Paranhos',
              'Parron', 'Pascoal', 'Pasetto', 'Pasqual', 'Paterno', 'Pedrosa', 'Peixoto', 'Pellegrini', 'Pena',
              'Pereira', 'Peres', 'Peruchi', 'Pessini', 'Petrini', 'Piacenti', 'Piano', 'Piccini', 'Pico', 'Pignatari',
              'Pimentel', 'Pinheiro', 'Pinto', 'Pintor', 'Pires', 'Poletto', 'Portela', 'Porto', 'Prado', 'Prandini',
              'Quaresma', 'Quartim', 'Queiroga', 'Queiroz', 'Quintana', 'Quintella', 'Quintino', 'Quirino', 'Ramires',
              'Ramos', 'Rangel', 'Ranzani', 'Ranzolin', 'Rebelo', 'Reboucas', 'Regis', 'Rego', 'Reis', 'Resende',
              'Rezende', 'Ribeiro', 'Rinaldi', 'Rocha', 'Rodella', 'Rodrigues', 'Rodriguez', 'Rohwedder', 'Romano',
              'Romao', 'Romero', 'Rosa', 'Rosati', 'Rossato', 'Ruggiero', 'Sacramento', 'Saldanha', 'Salermo', 'Sales',
              'Salvatore', 'Sampaio', 'Sanches', 'Santana', 'Santini', 'Santos', 'Saraiva', 'Saramago', 'Sartori',
              'Sato', 'Sbardellini', 'Scarcella', 'Schimidt', 'Seabra', 'Seki', 'Serafim', 'Serra', 'Silva', 'Silveira',
              'Simas', 'Simionato', 'Siqueira', 'Sirangelo', 'Soares', 'Sobral', 'Solano', 'Souza', 'Stefanelli',
              'Takahashi', 'Tavares', 'Teixeira', 'Teles', 'Telles', 'Tessari', 'Tognoli', 'Toldo', 'Torquato',
              'Torres', 'Toscano', 'Trancoso', 'Trindade', 'Uchoa', 'Ueda', 'Ugalde', 'Vargas', 'Vasconcelos',
              'Vasques', 'Vaz', 'Vazquez', 'Veiga', 'Veloso', 'Venceslau', 'Ventura', 'Veras', 'Veronezi', 'Viana',
              'Vicente', 'Vicentini', 'Vieira', 'Villasboas', 'Viscardi', 'Watanabe', 'Weber', 'Xavier', 'Ximenes',
              'Yamada', 'Zanatta', 'Zanetti', 'Zanini', 'Zanon', 'Zanotto', 'Zappia', 'Zerbinatti', 'Zerbini', 'Zilli',
              'Zorzi', 'Zucolotto'
              ]
print(f"sobrenomes: {len(sobrenomes)}, sobrenomes únicos: {len(set(sobrenomes))}\n")

# combinação entre os primeiros nomes e sobrenomes, gerando 840000 nomes únicos
# esse é a quantidade mínima de nomes diferentes que precisamos para conseguirmos
# 1000000 de linhas com 80% de nomes únicos
# e 20% de nomes que se repetem, em média, 5 vezes
nomes = []
for n in primeiros_nomes:
    for s in sobrenomes:
        nomes.append(f"{n}{s}")
print(f"nomes: {len(nomes)}, nomes únicos: {len(set(nomes))}\n")

# cargas dos testes de desempenho
cargas = [1000, 10000, 50000, 100000, 500000, 1000000]
# cargas = [50, 100]
carga_maxima = cargas[-1]
print(f"carga máxima: {carga_maxima}")

# amostra de CPFs únicos, o suficiente para a carga máxima
cpfs = random.sample(range(10000000000, 99999999999), carga_maxima)
print(f"cpfs: {len(cpfs)}, cpfs únicos: {len(set(cpfs))}\n")

# a porcentagem dos nomes repetidos para cada carga
# entre as linhas 1 e 1000, haverá 20% de nomes repetidos
# o mesmo entre as linhas 1 e 10000, assim como para cada carga
porcentagem_nomes_repetidos = 0.2
print(f"porcentagem de nomes repetidos: {porcentagem_nomes_repetidos}\n")

# as linhas do arquivo de texto
linhas = []

# frequência dos nomes repetidos
freq_nomes_repetidos = {}

# define a repetição média
repeticao_media = 5

for carga in cargas:
    print(f"carga: {carga}")
    # para cada carga, calcula quantos nomes repetidos são esperados
    # e quantos nomes diferentes são precisos para atingir esse valor,
    # considerando a repeticao média
    nomes_repetidos_esperados = int(carga * porcentagem_nomes_repetidos)
    min_nomes_repetidos = int(nomes_repetidos_esperados / repeticao_media)
    print(
        f"nomes repetidos esperados: {nomes_repetidos_esperados}"
        f", qnt. mínima dos nomes repetidos: {min_nomes_repetidos}\n")

    # enquanto as linhas não atingirem a metade da carga,
    # um nome é escolhido aleatoriamente entre a lista total de nomes,
    # então, ele é removido da lista e adicionado em uma nova linha
    while len(linhas) < int(carga / 2):
        cpf = cpfs[len(linhas)]
        nome = random.choice(nomes)
        nomes.remove(nome)

        linhas.append(f"{nome} {cpf}")
        print(f"{len(linhas)}")

    # enquanto o dicionário com os nomes que serão repetidos não atingir
    # a quantidade mínima de nomes diferentes a serem repetidos,
    # um nome é escolhido aleatoriamente entre a lista total de nomes,
    # então, ele é removido da lista e adicionado ao dicionário,
    # por fim, é adicionado em uma nova linha
    while len(freq_nomes_repetidos) < min_nomes_repetidos:
        cpf = cpfs[len(linhas)]
        nome = random.choice(nomes)
        nomes.remove(nome)
        freq_nomes_repetidos[nome] = freq_nomes_repetidos.get(nome, 0) + 1

        linhas.append(f"{nome} {cpf}")
        print(f"{len(linhas)}")
        print(f"qnt. nomes repetidos: {len(freq_nomes_repetidos)}"
              f", nomes repetidos: {sum(freq_nomes_repetidos.values())}")

    # garante que todos os nomes no dicionários ocorrem pelo menos 2 vezes
    # isso é para previnir de "falsos repetidos"
    # já que posteriormente, os nomes do dicionário são repetidos de forma aleatória
    for nome, freq in freq_nomes_repetidos.items():
        if freq < 2:
            cpf = cpfs[len(linhas)]
            freq_nomes_repetidos[nome] = freq_nomes_repetidos.get(nome, 0) + 1
            linhas.append(f"{nome} {cpf}")
            print(f"{len(linhas)}")
            print(f"qnt. nomes repetidos: {len(freq_nomes_repetidos)}"
                  f", nomes repetidos: {sum(freq_nomes_repetidos.values())}")

    # enquanto as ocorrências totais de repetição não atingirem o valor esperado essa carga,
    # um nome é escolhido aleatoriamente entre o dicionário de nomes a serem repetidos,
    # então, sua frequência é incrementada e ele é adicionado em uma nova linha
    while sum(freq_nomes_repetidos.values()) < nomes_repetidos_esperados:
        cpf = cpfs[len(linhas)]
        nome = random.choice(list(freq_nomes_repetidos.keys()))
        freq_nomes_repetidos[nome] = freq_nomes_repetidos.get(nome, 0) + 1
        linhas.append(f"{nome} {cpf}")
        print(f"{len(linhas)}")
        print(f"qnt. nomes repetidos: {len(freq_nomes_repetidos)}"
              f", nomes repetidos: {sum(freq_nomes_repetidos.values())}")

    # enquanto as linhas não atingirem o valor da carga,
    # um nome é escolhido aleatoriamente entre a lista total de nomes,
    # então, ele é removido da lista e adicionado em uma nova linha
    while len(linhas) < carga:
        cpf = cpfs[len(linhas)]
        nome = random.choice(nomes)
        nomes.remove(nome)

        linhas.append(f"{nome} {cpf}")
        print(f"{len(linhas)}")

    print()

# todas as linhas são salvas em um arquivo de texto
file_path = "nova_entrada.txt"
with open(file_path, "w") as file:
    file.write("\n".join(linhas))
