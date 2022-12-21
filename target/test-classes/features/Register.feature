@Register
  Feature: Register

    Scenario: Kullanici hesap acma

      Given  Kullanici gecerli verileri girerek request yapar
      Then  Kullanici Status Code 201 oldugunu dogrular
      And  Kullanici register data dogrulamasi yapar
