package com.depa.form.model;

import com.depa.form.model.question.Question;
import com.depa.form.model.question.QuestionType;
import com.depa.form.model.question.SubjectiveQuestion;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class QuestionTest {

    @Test
    public void testInputQuestion() {
        Question underTest = SubjectiveQuestion.create("input question",null);

        Assert.assertThat(underTest.getName(), CoreMatchers.equalTo("input question"));
        Assert.assertThat(underTest.getType(), CoreMatchers.equalTo(QuestionType.SUBJECTIVE));
        Assert.assertThat(underTest.getAttributes(), CoreMatchers.nullValue());
    }
}