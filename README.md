# Survery-App_Rest-API

Technology Stack: Spring-Boot, H2 Database, JPA

This project is built to create, manage surveys, questions and answers. It consists of following 2 spring boot rest controllers, Master Controller has service end points for master data management like survey, questions, answers and their mappings. Survey controller has service end points transaction data management like responding to a survey, fetch survey reports.

Below given are the service end points and sample JSON inputs for available functions.
REST-ENDPOINT URL
http://localhost:8080/master/createSurvey - To create a new survey with Topic has description SAMPLE REQUEST
{ "surveySubject" : "Facebook", "createdBy" : "Padma", "updatedBy" : null, "createdAt" : "2019-09-11", "updatedAt" : null }

REST-ENDPOINT URL
http://localhost:8080/master/saveQuestion - To create or edit master list of questions.

SAMPLE REQUEST
{ "id" : 0, "questionDescription" : "How do you use Facebook?", "createdBy" : "Padma", "updatedBy" : null, "createdAt" : "2019-09-11", "updatedAt" : null }

REST-ENDPOINT URL
http://localhost:8080/master/getQuestion - To list the Question in a Survey

SAMPLE REQUEST
{ "id" : 0 }

REST-ENDPOINT URL
http://localhost:8080/master/deleteQuestion - To delete a question from master list

SAMPLE REQUEST
{ "id" : 1 }

REST-ENDPOINT URL
http://localhost:8080/master/saveAnswer - To create or edit master list of answer options.

SAMPLE REQUEST
{ "id" : 0, "answerDescription" : "20 hours per day", "createdBy" : "Sutha", "updatedBy" : null, "createdAt" : "2017-09-11", "updatedAt" : null }

REST-ENDPOINT URL
http://localhost:8080/master/getAnswer - to list the answers from master list

SAMPLE REQUEST
{ "id" : 0 }

REST-ENDPOINT URL
http://localhost:8080/master/deleteAnswer - To delete a answer from master list

SAMPLE REQUEST
{ "id" : 0 }

REST-ENDPOINT URL
http://localhost:8080/master/saveQuestionAnswerMapping- To map a question and answer options for a survey.

SAMPLE REQUEST
{ "id" : 0, "surveyMaster" :{ "id" : 3 }, "surveyQuestionMaster" : { "id" : 7 }, "surveyAnswerMaster" :{ "id" : 8 }, "createdBy" : "Padhu", "updatedBy" : null, "createdAt" : "2019-09-11", "updatedAt" : null }

REST-ENDPOINT URL
http://localhost:8080master/getQuestionAnswerMapping - to list the Questions & its Answers in a Survey

SAMPLE REQUEST
{ "id" : 0 }

REST-ENDPOINT URL
http://localhost:8080/master/deleteQuestionAnswerMapping - to detach a question or answer mapping for a survey.

SAMPLE REQUEST { "id" : 0, "surveyMaster" :{ "id" : 3 }, "surveyQuestionMaster" : { "id" : 7 }, "surveyAnswerMaster" :{ "id" : 8 } }

REST-ENDPOINT URL
http://localhost:8080/survey/saveSurveyResponse - To save the user response to a survey question.

SAMPLE REQUEST
{ "id": 0, "surveyMaster": { "id": 3, "surveySubject": "Facebook", "createdBy": "Padma", "updatedBy": null, "createdAt": "2019-09-11T00:00:00.000+0000", "updatedAt": null }, "surveyQuestionMaster": { "id": 7, "questionDescription": "Since 3 do you use Facebook?", "createdBy": "Padma", "updatedBy": null, "createdAt": "2019-09-11T00:00:00.000+0000", "updatedAt": null }, "surveyAnswerMaster": { "id": 10, "answerDescription": "24 hours per day", "createdBy": "Sutha", "updatedBy": null, "createdAt": "2017-09-11T00:00:00.000+0000", "updatedAt": null } }

REST-ENDPOINT URL
http://localhost:8080/survey/fetchQuestionsBySurvey - To fetch the list of questions mapped a survey

SAMPLE REQUEST
{ "id" : 3 }

REST-ENDPOINT URL
http://localhost:8080/survey/fetchQuestionsAnswersMappingByQuestion - to fetch the answers given by users to a question for a survey.

SAMPLE REQUEST
{ "id" : 3 }

REST-ENDPOINT URL
http://localhost:8080/survey/fetchQuestionsAnswersMappingBySurvey - to fetch list of questions and respective answers mapped to a survey.

SAMPLE REQUEST
{ "id" : 3 }

REST-ENDPOINT URL
http://localhost:8080/survey/fetchSurveyResponseBySurvey - To get the answer given by the user on a survey.

SAMPLE REQUEST
{ "id" : 3 }

REST-ENDPOINT URL
http://localhost:8080/survey/fetchSurveyResponseByQuestion - To get the answer given by the user for a question on a survey.

SAMPLE REQUEST
{ "id" : 3 }

