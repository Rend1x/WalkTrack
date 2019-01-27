package com.example.asus.walktrack.Model;

public class Metric {

        public int aerobic;
        public long date;
        public int run;
        public int walk;
        public int allCount;

        public Metric(int aerobic, int date, int run, int walk) {
                this.aerobic = aerobic;
                this.date = date;
                this.run = run;
                this.walk = walk;
        }

        public Metric() {
        }

        public int getAllCount() {
                return allCount;
        }

        public void setAllCount(int allCount) {
                this.allCount = allCount;
        }
}
