package com.example.fooddelivery

import com.example.fooddelivery.model.Restaurant

object DataStore {

    var emailInfo = ""
    var passInfo = ""

    fun getDataSet(): List<Restaurant>{
        return listOf(
            Restaurant(33760,"Du Miên Garden Cafe - Phan Văn Trị","7 Phan Văn Trị, P. 10,Quận Gò Vấp,TP. HCM",R.drawable.img33760),
            Restaurant(978,"Country House Cafe","18C Phan Văn Trị, P. 10,Quận Gò Vấp,TP. HCM",R.drawable.img978),
            Restaurant(82801,"Hẻm Spaghetti - Nguyễn Oanh","212/22 Nguyễn Oanh, P. 17, Quận Gò Vấp, TP. HCM",R.drawable.img82801),
            Restaurant(149154,"Lava Coffee - Quang Trung","61 Quang Trung, P. 10, Quận Gò Vấp, TP. HCM",R.drawable.img149154),
            Restaurant(194867,"Mì Cay Naga - 224 Phạm Văn Đồng","224 Phạm Văn Đồng, P.1, Quận Gò Vấp, TP. HCM",R.drawable.img194867),
            Restaurant(25656,"City House Cafe - Sân Vườn Lãng Mạn","221 Huỳnh Khương An, P. 5, Quận Gò Vấp, TP. HCM",R.drawable.img25656),
            Restaurant(66844,"Nhi Nhi Quán - Đặc Sản Phan Rang","125/48 Lê Đức Thọ, P. 17, Quận Gò Vấp, TP. HCM",R.drawable.img66844),
            Restaurant(33645,"Yuri Yuri - Ẩm Thực Hàn Quốc","358 Nguyễn Văn Nghi, P. 7, Quận Gò Vấp, TP. HCM",R.drawable.img),
            Restaurant(252442,"Trà Sữa Gong Cha - 貢茶 - Phan Văn Trị","595 Phan Văn Trị, P. 5, Quận Gò Vấp, TP. HCM",R.drawable.img_252442),
            Restaurant(12513,"Oasis Cafe","26/14 Phạm Văn Đồng, P. 3, Quận Gò Vấp, TP. HCM",R.drawable.img_12513),
            Restaurant(199622,"Buzza Pizza - Emart Gò Vấp","Tầng Trệt Emart Gò Vấp - 366 Phan Văn Trị, P. 5, Quận Gò Vấp, TP. HCM",R.drawable.img_199622),
            Restaurant(651063,"Dallas Cakes & Coffee - Quang Trung","T6 Quang Trung, P. 10, Quận Gò Vấp, TP. HCM",R.drawable.img_651063),
            Restaurant(60915,"Hot & Cold - Trà Sữa & Xiên Que - Quang Trung","804 Quang Trung, P. 10, Quận Gò Vấp, TP. HCM",R.drawable.img_1),
            Restaurant(112585,"Papaxốt - Quang Trung","458 Quang Trung, P. 10, Quận Gò Vấp, TP. HCM",R.drawable.img112585),
            Restaurant(91979,"SaiGon Chic Cafe","82 Đường Số 27, P. 6, Quận Gò Vấp, TP. HCM",R.drawable.img91979),
            Restaurant(28883,"Pizza Hut - Quang Trung","283 Quang Trung, Quận Gò Vấp, TP. HCM",R.drawable.img28883),
            Restaurant(129725,"Bánh Mì Chảo & Món Ngon Hoa Việt - Quán Cô 3 Hậu","36 Đường Số 18, P. 8, Quận Gò Vấp, TP. HCM",R.drawable.img129725),
            Restaurant(46668,"Kichi Kichi Lẩu Băng Chuyền - Quang Trung","1 Quang Trung, Quận Gò Vấp, TP. HCM",R.drawable.img46668),
            Restaurant(158187,"The Coffee House - Quang Trung","293 Quang Trung, Quận Gò Vấp, TP. HCM",R.drawable.img158187),
            Restaurant(30102,"Cánh Đồng Quán - Lẩu Nướng Tại Bàn - Dương Quảng Hàm","310/14 Dương Quảng Hàm, P. 5, Quận Gò Vấp, TP. HCM",R.drawable.img30102),
            Restaurant(83857,"Chú Tèo Buffet Nướng 99K - K26 Dương Quảng Hàm","N01 Chung Cư K26 Dương Quảng Hàm, P. 7, Quận Gò Vấp, TP. HCM",R.drawable.img83857),

            )
    }
}

