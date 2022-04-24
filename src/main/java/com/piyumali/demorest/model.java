package com.piyumali.demorest;


		public class model  {
			private int userID;
			private String name;
			private String district;
			private String units;
			private String dues;
			private String date;
			
			
			public model() {
				super();
				
			}

			public int getId() {
				return userID;
			}
			
			public model(String name, String district, String units) {
				super();
				this.name = name;
				this.district = district;
				this.units = units;
			}
			

			public void setId(int userID) {
				this.userID = userID;
			}
			
			public String getname() {
				return name;
			}
			
			public void setname(String name) {
				this.name = name;
			}
			
			public String getdistrict() {
				return district;
			}
			
			public void setdistrict(String district) {
				this.district = district;
			}
			
			public String getunits() {
				return units;
			}
			
			public void setunits(String units) {
				this.units = units;
			}
			
			public String getdues() {
				return dues;
			}
			
			public void setdues(String dues) {
				this.dues = dues;
			}
			
			public String getdate() {
				return date;
			}
			
			public void setdate(String date) {
				this.date = date;
			}
			
			
			@Override
			public String toString() {
				return "Bill [userID=" + userID + ", name=" + name + ", district=" + district + ", units=" + units
						+ ", dues=" + dues + ", date=" + date + "]";
			}
			

		}

