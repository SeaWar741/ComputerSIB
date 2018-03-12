require 'sqlite3'

class Chef

 def initialize(first_name, last_name, birthday, email, phone)
    @first_name = first_name
    @last_name = last_name
    @birthday = birthday
    @email = email
    @phone = phone
    # @created_at = created_at
    # @updated_at = updated_at
    Chef.db.execute("
      INSERT INTO chefs
        (first_name, last_name, birthday, email, phone, created_at, updated_at)
        VALUES
        ('#{@first_name}', '#{@last_name}', '#{@birthday}', '#{@email}', '#{@phone}', DATETIME('now'), DATETIME('now'))
    ")
  end

 def self.all
    Chef.db.execute("SELECT * FROM chefs;")
  end

 def self.where(field,value)
    Chef.db.execute("SELECT * FROM chefs WHERE #{field}= ?", value)
  end

 def self.find(value)
    Chef.db.execute("SELECT * FROM chefs WHERE id = ?", value).first
  end

 def self.delete(value)
    Chef.db.execute ("DELETE FROM chefs WHERE id = #{value}")
  end

 def self.create_table
    Chef.db.execute(
      <<-SQL
        CREATE TABLE chefs (
          id INTEGER PRIMARY KEY AUTOINCREMENT,
          first_name VARCHAR(64) NOT NULL,
          last_name VARCHAR(64) NOT NULL,
          birthday DATE NOT NULL,
          email VARCHAR(64) NOT NULL,
          phone VARCHAR(64) NOT NULL,
          created_at DATETIME NOT NULL,
          updated_at DATETIME NOT NULL
        );
      SQL
    )
  end

 def self.seed
    Chef.db.execute(
      <<-SQL
        INSERT INTO chefs
          (first_name, last_name, birthday, email, phone, created_at, updated_at)
        VALUES
          ('Ferran', 'Adriá', '1985-02-09', 'ferran.adria@elbulli.com', '42381093238', DATETIME('now'), DATETIME('now')),
          ('López', 'Diana', '1986-10-06', 'ferran.adria@lopez.com', '42381093238', DATETIME('now'), DATETIME('now')),
          ('García', 'Rafael', '1992-10-15', 'ferran.adria@garcia.com', '42381093238', DATETIME('now'), DATETIME('now')),
          ('Pundt', 'Juma', '1991-06-06', 'ferran.adria@pundt.com', '42381093238', DATETIME('now'), DATETIME('now'));
        -- Añade aquí más registros
      SQL
    )
  end


 private

 def self.db
    @@db ||= SQLite3::Database.new("chefs.db")
  end

end