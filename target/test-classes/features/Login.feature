@login
  Feature: Login

    Scenario: Gecerli Datalarla Giris Yapma
      Given Kullanici gecerli datalarla request yapar
      Then Kullanici status code 200 oldugunu dogrular
      Then Kullanici Api ile login dogrulamasi yapar
