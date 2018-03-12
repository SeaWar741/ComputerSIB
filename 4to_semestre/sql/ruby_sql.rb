require 'sqlite3'

class Chef
def initialize (id,first_name,last_name,birthday,email,phone)
  @id = id
  @first_name = first_name
  @last_name = last_name
  @birthday = birthday
  @email = email
  @phone = phone
    Chef.db.execute("
      INSERT INTO chefs
        (first_name, last_name, birthday, email, phone, created_at, updated_at)
        VALUES
        ('#{@first_name}', '#{@last_name}', '#{@birthday}', '#{@email}', '#{@phone}', DATETIME('now'), DATETIME('now'))")
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
          ('Jose', 'Ramirez', '1999-05-10', 'joseram.cool@guimail.com', '47713645738', DATETIME('now'), DATETIME('now')),
          ('Pepe', 'Lopez', '1998-08-11', 'pepitolopezaurio@himail.com', '56824582019', DATETIME('now'), DATETIME('now')),
          ('Raul', 'Solar', '2000-10-09', 'solarpower@holyymail.com', '56833090118', DATETIME('now'), DATETIME('now')),
          ('Zhongli', 'Chan', '1980-18-12', 'wozhunchan@zhongguo.com', '13251824956', DATETIME('now'), DATETIME('now')),
          ('Mathew', 'Polonski', '2001-08-01', 'lord.mathew@mirreymail.com', '41515512348', DATETIME('now'), DATETIME('now'));
        -- Añade aquí más registros
      SQL
    )
  end

def self.table
   Chef.db.execute(
      <<-SQL

    Select * From chefs;
          SQL
    )
end

def self.all
   Chef.db.execute(
      <<-SQL

    Select * From chefs;
          SQL
    )
end

def self.where(condition,value)
   Chef.db.execute(
      <<-SQL

    SELECT * FROM chefs WHERE "#{condition} = #{value}";
          SQL
    )
end

def self.where(id,number)
   Chef.db.execute(
      <<-SQL

SELECT * FROM chefs WHERE "#{id} = #{number}"
          SQL
    )
end

def self.delete(value)
    Chef.db.execute (
      <<-SQL
      DELETE FROM chefs WHERE "#{id} = #{value}"
        SQL
    )
  end

# def self.INSERT(value)
#     Chef.db.execute (
#       <<-SQL
#       INSERT INTO chefs ("#{field1},#{field2},#{field3}")
#       )
# end
# def self.chef =Chef.new(data)chef.save
#    Chef.db.execute(
#       <<-SQL

#       INSERT INTO chefs (field1, field2, ...) VALUES(value1, value2, ...)
#           SQL
#     )
# end

  private

  def self.db
    @@db ||= SQLite3::Database.new("chefs.db")
  end

end


Chef.create_table
Chef.seed
Chef.table

