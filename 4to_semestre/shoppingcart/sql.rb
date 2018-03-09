require 'sql'

class Kukulkan
def initialize (id,user,password,security_answer)
  @id = id
  @user = user
  @password = password
  @security_answer = security_answer


    Kukulkan.db.execute("
      INSERT INTO kukulkan_database
        (user, password, security_answer, created_at, updated_at)
        VALUES
        ('#{@user}', '#{@password}', '#{@security_answer}', DATETIME('now'), DATETIME('now'))")
end
  def self.create_table
    Kukulkan.db.execute(
      <<-SQL
        CREATE TABLE kukulkan_database (
          id INTEGER PRIMARY KEY AUTOINCREMENT,
          user VARCHAR(64) NOT NULL,
          password VARCHAR(64) NOT NULL,
          security_answer DATE NOT NULL,
          created_at DATETIME NOT NULL,
          updated_at DATETIME NOT NULL
        );
      SQL
    )
  end

  def self.seed
    Kukulkan.db.execute(
      <<-SQL
        INSERT INTO kukulkan_database
          (user, password, security_answer, created_at, updated_at)
        VALUES
          ('theyought47@einrot.com', 'efb6aacbde32d26bff954cfed9ffe3372104cf18', '17765ffe166b72d80a602ba7daaf1029c582f531', DATETIME('now'), DATETIME('now')),
          ('wcena201@ndfbmail.ga', '22fa9a71b6eaf5ad83d6038f33491728982856d7', '0fbda0462c9539b02f0498148e0ab135031cdaa8', DATETIME('now'), DATETIME('now')),
          ('0syed.sab@pokeett.site', 'cf2bb7ec965f090f8e48304860e2f629c0f8a99f', '525b752f115f4d0790fff75b07aaa3e0897832a5', DATETIME('now'), DATETIME('now')),
          ('idigao.pga@888z5.ml', 'fa26e6e06ac77d53c3a0e4092af149a711c61b82', 'c50a2b3c108227acaf199be912f963ae88e32a23', DATETIME('now'), DATETIME('now')),
          ('juanca741@gmail.com', 'c938af029a1986d6efe956ccd05dd43989b71312', '1e54b98763365a39b9041b49e8b3fce4b5e4dcb2', DATETIME('now'), DATETIME('now'));
        -- Añade aquí más registros
      SQL
    )
  end

def self.table
   Kukulkan.db.execute(
      <<-SQL

    Select * From kukulkan_database;
          SQL
    )
end

def self.all
   Kukulkan.db.execute(
      <<-SQL

    Select * From kukulkan_database;
          SQL
    )
end

def self.where(condition,value)
   Kukulkan.db.execute(
      <<-SQL

    SELECT * FROM kukulkan_database WHERE "#{condition} = #{value}";
          SQL
    )
end

def self.where(id,number)
   Kukulkan.db.execute(
      <<-SQL

SELECT * FROM kukulkan_database WHERE "#{id} = #{number}"
          SQL
    )
end

def self.delete(value)
    Kukulkan.db.execute (
      <<-SQL
      DELETE FROM kukulkan_database WHERE "#{id} = #{value}"
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
    @@db ||= SQL::Database.new("kukulkan_database.sql")
  end

end


Kukulkan.create_table
Kukulkan.seed
Kukulkan.table

