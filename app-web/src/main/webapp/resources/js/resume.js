/**
 * Created with IntelliJ IDEA.
 * User: oleg
 * Date: 30.04.14
 * Time: 18:29
 * To change this template use File | Settings | File Templates.
 */
jQuery(document).ready(function (e) {
    $ = jQuery;

    var recommendationIndex = 0;
    $("#addRecommendation").click(function () {
        $.get("/appendRecommendation", { fieldId: recommendationIndex++},
            function (data) {
                $("#addRecommendationRow").before(data);
            });
    });

    var abilityIndex = 0;
    $("#addAbility").click(function () {
        $.get("/appendAbility", { fieldId: abilityIndex++},
            function (data) {
                $("#addAbilityRow").before(data);
            });
    });

    var experienceIndex = 0;
    $("#addExperience").click(function () {
        $.get("/appendExperience", { fieldId: experienceIndex++},
            function (data) {
                $("#addExperienceRow").before(data);
            });
    });

    var educationIndex = 0;
    $("#addEducation").click(function () {
        $.get("/appendEducation", { fieldId: educationIndex++},
            function (data) {
                $("#addEducationRow").before(data);
            });
    });


    /*-----------------------------------------------------------------------------------*/
    /*	Validation
     /*-----------------------------------------------------------------------------------*/
//    $('#resumeForm').validate({
//        errorLabelContainer: $("#search-error-container")
//    });
});
