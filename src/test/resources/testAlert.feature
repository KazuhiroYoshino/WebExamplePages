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
フィーチャ: ポップアップ機能
  @tag1
	シナリオ: ボタンを押してAlertを表示し、メッセージを確認する
		前提 Alert Test Pageページを開く

	シナリオ: OKボタンのみの場合
		かつ "Alert"ボタンを押す
		ならば ポップアップ画面に"I am a JS Alert"と表示される
		もし ポッフアップの"OK"ボタンを押す
		ならば 画面に"You successfully clicked an alert"と表示される

	シナリオ: OKボタンとCANCELボタンの場合
		かつ "Confirm"ボタンを押す
		ならば ポップアップ画面に"I am a JS Confirm"と表示される
		もし ポッフアップの"OK"ボタンを押す
		ならば 画面に"You clicked: Ok"と表示される

		かつ "Confirm"ボタンを押す
		ならば ポップアップ画面に"I am a JS Confirm"と表示される
		もし ポッフアップの"CANCEL"ボタンを押す
		ならば 画面に"You clicked: Cancel"と表示される

	シナリオ: PromptとOKボタンとCANCELボタンの場合
		かつ "Prompt"ボタンを押す
		ならば ポップアップ画面に"I am a JS prompt"と表示される
		もし ポップアップ画面のプロンプトに"TestTestTest"と入力する
		もし ポッフアップの"OK"ボタンを押す
		ならば 画面に"You entered: TestTestTest"と表示される

		かつ "Prompt"ボタンを押す
		ならば ポップアップ画面に"I am a JS prompt"と表示される
		もし ポップアップ画面のプロンプトに"TestTestTest"と入力する
		もし ポッフアップの"CANCEL"ボタンを押す
		ならば 画面に"You entered: null"と表示される

	シナリオ: ブラウザを閉じる
	 	もし ブラウザを閉じる

