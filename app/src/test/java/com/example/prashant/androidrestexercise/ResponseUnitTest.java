package com.example.prashant.androidrestexercise;

import android.content.Context;

import com.example.prashant.androidrestexercise.Logic.BaseUseCase;
import com.example.prashant.androidrestexercise.Logic.DataModel;
import com.example.prashant.androidrestexercise.Logic.DataObject;
import com.example.prashant.androidrestexercise.UserInterface.MVP.ListContractor;
import com.example.prashant.androidrestexercise.UserInterface.MVP.ListPresenter;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.hamcrest.Matchers.hasItem;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ResponseUnitTest {

    Context con;
    @Mock
    private ListContractor.View mockView;

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    private BaseUseCase mockBaseUsecase;

    private ListPresenter listPresenter;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        listPresenter = new ListPresenter(mockBaseUsecase, mockView);
    }

    @Test
    public void testOnRequestSuccess() {
        when(mockBaseUsecase.getContent()).thenReturn(Observable.just(getResponse()));
        listPresenter.getDataList();
        verify(mockView).loadDataList(any());
    }

    private DataModel getResponse() {
        DataModel dResponse = new DataModel();
        List<DataObject> data = new ArrayList<>();
        DataObject tData = new DataObject();
        tData.setmName("Test Name....");
        tData.setmDescription("Test detailed Description.....");
        tData.setmImage("Test Url....");
        data.add(tData);
        dResponse.setmData(data);
        return dResponse;
    }
    @Test
    public final void shouldContainCertainListItem() {
        List<DataObject> data = new ArrayList<>();

        final List<DataObject> mockedList = mock(List.class);

        DataObject tData = new DataObject();
        tData.setmName("Test Name....");
        tData.setmDescription("Test detailed Description.....");
        tData.setmImage("Test Url....");

        mockedList.addAll(mockedList);

        verify(mockedList).addAll(mockedList);

    }


}