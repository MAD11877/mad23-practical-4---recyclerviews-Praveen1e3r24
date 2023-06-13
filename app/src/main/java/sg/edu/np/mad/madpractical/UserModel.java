package sg.edu.np.mad.madpractical;

public class UserModel {

        String msg;
        String desc;

        public UserModel(String msg, String desc) {
            this.msg = msg;
            this.desc = desc;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }

