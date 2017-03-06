package hu.bme.mit.train.system;

import java.sql.Date;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import hu.bme.mit.train.controller.TrainControllerImpl;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.sensor.TrainSensorImpl;
import hu.bme.mit.train.user.TrainUserImpl;

public class TrainSystem {

	private TrainController controller = new TrainControllerImpl();
	private TrainSensor sensor = new TrainSensorImpl(controller);
	private TrainUser user = new TrainUserImpl(controller);
	private Table<Long, Integer, Integer> myTable = HashBasedTable.create();

	public TrainController getController() {
		return controller;
	}

	public TrainSensor getSensor() {
		return sensor;
	}

	public TrainUser getUser() {
		return user;
	}
	  
    public void putValues() {
    	Date date = new Date(0);
        myTable.put(date.getTime(), getController().getReferenceSpeed(), getUser().getJoystickPosition());
    }
}
