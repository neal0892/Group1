import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatientInformationTool {

	public Map<Integer, Map> getPatientDetails(String filepath) throws PatientInformationDetailsException {

		BufferedReader br = null;
		FileReader fr = null;
		List<PatientVO> listPatientVO = new ArrayList<PatientVO>();
		Map<String, List<PatientVO>> admissionBasedMap = new HashMap<String, List<PatientVO>>();
		Map<String, Integer> physicianBasedMap = new HashMap<String, Integer>();
		List<PatientVO> patVOList = new ArrayList<PatientVO>();
		Map<Integer,Map> result = new HashMap<Integer, Map>();

		try {
			fr = new FileReader(filepath);
			br = new BufferedReader(fr);

			String sCurrentLine;

			try {
				while ((sCurrentLine = br.readLine()) != null) {

					String[] arr = sCurrentLine.split(";");
					PatientVO patientVo = new PatientVO();

					validationHospitalManagement(arr);

					String admissionStr = arr[4];
					String dischargeStr = arr[5];
					String conversionformat = "dd/MM/yyyy";
					Date resultAdmissionDate = null;
					Date resultDischargeDate= null;
					DateFormat dateFormat = new SimpleDateFormat(conversionformat);

					try{
						resultAdmissionDate = dateFormat.parse(admissionStr);
						resultDischargeDate = dateFormat.parse(dischargeStr);

					} catch(Exception e){
						throw new PatientInformationDetailsException("Date Formatting exception");
					}

					patientVo.setPatientName(arr[0]);
					patientVo.setMrn(arr[1]);
					patientVo.setGender(arr[2].charAt(0));
					patientVo.setPhyId(arr[3]);
					patientVo.setAdmissionDate(resultAdmissionDate);
					patientVo.setDischargeDate(resultDischargeDate);

					//Calculating Bill
					Long billGenerated = 0l;
					int costPerDay = 0;
					int lengthOfStay = 0; 

					if(arr[3].substring(5).equals("GEN")){
						costPerDay = 1250;
					} else if(arr[3].substring(5).equals("NEU")){
						costPerDay = 1500;
					} else if(arr[3].substring(5).equals("ENT")){
						costPerDay = 1750;
					}

					lengthOfStay = (int) ((resultDischargeDate.getTime() - resultAdmissionDate.getTime()) / (1000 * 60 * 60 * 24));
					billGenerated = (long) (lengthOfStay * costPerDay);

					patientVo.setBill(billGenerated);

					listPatientVO.add(patientVo);
				}

				for (PatientVO patientVO : listPatientVO) {

					String dateStringAdmission = null;
					SimpleDateFormat sdfr = new SimpleDateFormat("dd/MM/yyyy");
					Date currVoAdmissionDate = null;
					currVoAdmissionDate = patientVO.getAdmissionDate();

					try{
						dateStringAdmission = sdfr.format(currVoAdmissionDate);
					}
					catch (Exception ex ){
						throw new PatientInformationDetailsException("Date Formatting exception");
					}

					if(admissionBasedMap.containsKey(dateStringAdmission)){
						patVOList = admissionBasedMap.get(dateStringAdmission);
						patVOList.add(patientVO);
						admissionBasedMap.put(dateStringAdmission, patVOList);
					} else{					
						patVOList =  new ArrayList<PatientVO>();
						patVOList.add(patientVO);
						admissionBasedMap.put(dateStringAdmission, patVOList);
					}

					if(physicianBasedMap.containsKey(patientVO.getPhyId().substring(5))){
						physicianBasedMap.put(patientVO.getPhyId().substring(5), physicianBasedMap.get(patientVO.getPhyId().substring(5))+1);
					}
					else{
						physicianBasedMap.put(patientVO.getPhyId().substring(5), 1);
					}
				}

				result.put(1, admissionBasedMap);
				result.put(2, physicianBasedMap);

			} catch (IOException e) {
				throw new PatientInformationDetailsException("IO exception");
			}

		} catch (FileNotFoundException e) {
			throw new PatientInformationDetailsException("File not found exception");
		}
		return result;
	}

	public void validationHospitalManagement(String[] arrInput) throws PatientInformationDetailsException{

		if(arrInput.length != 6){
			throw new PatientInformationDetailsException("All fields are not present");
		} else {
			if(arrInput[0].equals("")){
				throw new PatientInformationDetailsException("All fields are not present");
			} 
			else if(arrInput[1].equals("")){
				throw new PatientInformationDetailsException("All fields are not present");
			}
			else if(arrInput[2].equals("")){
				throw new PatientInformationDetailsException("All fields are not present");
			}
			else if(arrInput[3].equals("")){
				throw new PatientInformationDetailsException("All fields are not present");
			}
			else if(arrInput[4].equals("")){
				throw new PatientInformationDetailsException("All fields are not present");
			}
			else if(arrInput[5].equals("")){
				throw new PatientInformationDetailsException("All fields are not present");
			}
		}

		String patientName = arrInput[0];
		String mrn = arrInput[1];
		String phyIdStr = arrInput[3];
		String admissionStr = arrInput[4];
		String dischargeStr = arrInput[5];
		String conversionformat = "dd/MM/yyyy";
		Date resultAdmissionDate = null;
		Date resultDischargeDate= null;
		DateFormat dateFormat = new SimpleDateFormat(conversionformat);

		try {
			if ((!admissionStr.equals("") || admissionStr != null)
					&& (!dischargeStr.equals("") || dischargeStr != null)) {
				resultAdmissionDate = dateFormat.parse(admissionStr);
				resultDischargeDate = dateFormat.parse(dischargeStr);
			}

		} catch (Exception e) {
			throw new PatientInformationDetailsException("Date Formatting exception");
		}		

		if(resultAdmissionDate != null && resultDischargeDate != null){
			if(!resultAdmissionDate.before(resultDischargeDate)){
				throw new PatientInformationDetailsException("Admission date greater than Discharge date validation exception");
			}
		}

		if(!patientName.equals("") || patientName != null){
			Pattern p = Pattern.compile("[a-zA-Z\\s]+");
			Matcher m = p.matcher(patientName);
			if(!m.matches()){
				throw new PatientInformationDetailsException("Patient Name validation exception");
			}
		}

		if(!mrn.equals("") || mrn != null){
			if(!(mrn.substring(0, 2).equals("IN") || mrn.substring(0, 3).equals("OUT"))
					&& !(mrn.substring(2).matches("[0-9]+") || mrn.substring(3).matches("0-9]+"))){
				throw new PatientInformationDetailsException("MRN validation exception");
			}
		}

		if(!phyIdStr.equals("") || phyIdStr != null){
			if(!(phyIdStr.substring(0, 4).matches("[0-9]{4}$"))
					&& !(phyIdStr.substring(5).equals("GEN") || phyIdStr.substring(5).equals("NEU") || phyIdStr.substring(5).equals("ENT"))){

				throw new PatientInformationDetailsException("Physician Id validation exception");
			}
		}
	}

	public static void main(String[] args) throws PatientInformationDetailsException {
		String filepath = "input.txt";
		PatientInformationTool pr = new PatientInformationTool();

		try{
			Map<Integer,Map> res = pr.getPatientDetails(filepath);
			System.out.println(res);
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	class PatientVO {
		private String patientName;
		private String phyId;
		private Date admissionDate;
		private Date dischargeDate;
		private Character gender;
		private String mrn;
		private Long bill;

		public String getPatientName() {
			return patientName;
		}

		public void setPatientName(String patientName) {
			this.patientName = patientName;
		}

		public String getPhyId() {
			return phyId;
		}

		public void setPhyId(String phyId) {
			this.phyId = phyId;
		}

		public Date getAdmissionDate() {
			return admissionDate;
		}

		public void setAdmissionDate(Date admissionDate) {
			this.admissionDate = admissionDate;
		}

		public Date getDischargeDate() {
			return dischargeDate;
		}

		public void setDischargeDate(Date dischargeDate) {
			this.dischargeDate = dischargeDate;
		}

		public Character getGender() {
			return gender;
		}

		public void setGender(Character gender) {
			this.gender = gender;
		}

		public String getMrn() {
			return mrn;
		}

		public void setMrn(String mrn) {
			this.mrn = mrn;
		}

		public Long getBill() {
			return bill;
		}

		public void setBill(Long bill) {
			this.bill = bill;
		}

		@Override
		public String toString() {
			return "PatientVO [patientName=" + patientName + ", phyId=" + phyId
			+ ", admissionDate=" + admissionDate + ", dischargeDate="
			+ dischargeDate + ", gender=" + gender + ", mrn=" + mrn
			+ ", bill=" + bill + "]";
		}
	}

	class PatientInformationDetailsException extends Exception {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public PatientInformationDetailsException(String message) {
			super(message);
		}

		public PatientInformationDetailsException(Throwable throwable) {
			super(throwable);
		}

		public PatientInformationDetailsException(String message, Throwable throwable) {
			super(message, throwable);
		}

	}
}
