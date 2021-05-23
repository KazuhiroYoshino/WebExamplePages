#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
#language: ja
@tag
フィーチャ: ボタンを押すと、画面内の表示が変わる

  @tag1
	シナリオ: Show Messageボタンを押して、I am the message!! と画面に表示させる
		前提 Selenium Test Example Pageページを開く
		かつ "Show Message"ボタンを押す
		ならば 画面に"I am the message!!"と表示される

  @tag2
  シナリオ: フォーム入力後、サブミットボタン押下で入力内容が画面に反映される
  	もし "Input Text Here"に"テスト"と入力
  	もし "Check It"にチェックを入れる
  	もし Option選択を"Option 4"で選択する
  	もし radioボタンを"Radio 2"で選択する
  	もし "テキストエリア"に"Test Test Test Test Test"と入力
  	かつ "Submit"ボタンを押す
  	もし "2"秒待つ

		ならば 画面の"Form Resultsのtext"に"テスト"と表示される
		ならば 画面の"Form Resultsのcheckbox"に"on"と表示される
		ならば 画面の"Form Resultsのselect"に"option4"と表示される
		ならば 画面の"Form Resultsのradio"に"radio2"と表示される
		ならば 画面の"Form Resultsのtextarea"に"Test Test Test Test Test"と表示される

	シナリオ: ブラウザを閉じる
	 	もし ブラウザを閉じる
