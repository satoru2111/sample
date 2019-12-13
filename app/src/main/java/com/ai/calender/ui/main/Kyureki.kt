package com.ai.calender.ui.main

object Kyureki {

    //QReki.RokuYo(西暦年,月,日)="旧暦年.月.日 六曜"

    // 1999-2030 Old2New パラメータ
    //var nyymin = 1999;
    //var nyymax = 2030;
    internal var nyymin = 1999
    internal var nyymax = 2030
    //var o2ntbl = [[611,2350]	,[468,3222]	,[316,7317]	,[559,3402]	,[416,3493]
    //	,[288,2901]	,[520,1388]	,[384,5467]	,[637,605]	,[494,2349]	,[343,6443]
    //	,[585,2709]	,[442,2890]	,[302,5962]	,[533,2901]	,[412,2741]	,[650,1210]
    //	,[507,2651]	,[369,2647]	,[611,1323]	,[468,2709]	,[329,5781]	,[559,1706]
    //	,[416,2773]	,[288,2741]	,[533,1206]	,[383,5294]	,[624,2647]	,[494,1319]
    //	,[356,3366]	,[572,3475]	,[442,1450]};
    internal var o2ntbl = arrayOf(
        intArrayOf(611, 2350),
        intArrayOf(468, 3222),
        intArrayOf(316, 7317),
        intArrayOf(559, 3402),
        intArrayOf(416, 3493),
        intArrayOf(288, 2901),
        intArrayOf(520, 1388),
        intArrayOf(384, 5467),
        intArrayOf(637, 605),
        intArrayOf(494, 2349),
        intArrayOf(343, 6443),
        intArrayOf(585, 2709),
        intArrayOf(442, 2890),
        intArrayOf(302, 5962),
        intArrayOf(533, 2901),
        intArrayOf(412, 2741),
        intArrayOf(650, 1210),
        intArrayOf(507, 2651),
        intArrayOf(369, 2647),
        intArrayOf(611, 1323),
        intArrayOf(468, 2709),
        intArrayOf(329, 5781),
        intArrayOf(559, 1706),
        intArrayOf(416, 2773),
        intArrayOf(288, 2741),
        intArrayOf(533, 1206),
        intArrayOf(383, 5294),
        intArrayOf(624, 2647),
        intArrayOf(494, 1319),
        intArrayOf(356, 3366),
        intArrayOf(572, 3475),
        intArrayOf(442, 1450)
    )

    //var nmdays = new Array(31,28,31,30,31,30,31,31,30,31,30,31);
    internal var nmdays = intArrayOf(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
    internal var otbl = Array(14) { IntArray(2) }
    internal var nyy: Int = 0
    internal var nmm: Int = 0
    internal var ndd: Int = 0
    internal var uruu: String = ""//   ・・・ uruu : "閏" or "";
    internal var oyy: Int = 0
    internal var omm: Int = 0
    internal var odd: Int = 0
    internal var DofNyy: Int = 0

    fun RokuYo(nyy: Int, nmm: Int, ndd: Int): String {
        get_N2O(nyy, nmm, ndd)    // 年、月、日、閏　の順に答えが返る。public
        //		var Rokuyou = new Array('大安','赤口','先勝','友引','先負','仏滅')
        val Rokuyou = arrayOf("大安", "赤口", "先勝", "友引", "先負", "仏滅")
        var ANS = ""
        //		if (ans[0] > 0) {
        if (oyy > 0) {
            //			ANS1.value = '旧暦 ' + ans[0] + '/' + ans[3] + ans[1] + '/' + ans[2];
            //			ANS16.value = Rokuyou[(ans[1] + ans[2]) % 6];	// 六曜
            ANS = Rokuyou[(omm + odd) % 6]
        } else {
            //			ANS1.value = '変換不能。入力をチェック！';
            ANS = ""
        }
        return ANS
    }

    // 新暦→旧暦変換
    // 戻り値は Array(nyy,nmm,ndd,uruu)   ・・・ uruu : "閏" or "";
    // Errorなら、 Array(0,0,0,"") を返す
    //function get_N2O(nyy,nmm,ndd) {
    internal fun get_N2O(nyy: Int, nmm: Int, ndd: Int) {
        //	var oyy,omm,odd,uruu,DofNyy;
        //	if (!ymdCheck(nyy,nmm,ndd,0)) return Array(0,0,0,"");	// 入力値チェック（0:新暦）
        DofNyy = NumberDays(nyy, nmm, ndd)
        oyy = nyy
        TblExpand(oyy)
        if (DofNyy < otbl[0][0]) {
            oyy--
            DofNyy += 365 + LeapYear(oyy)
            TblExpand(oyy)
        }

        //　for (var i = 12; i >= 0 ; i--) {
        for (i in 12 downTo 0) {
            if (otbl[i][1] != 0) {
                if (otbl[i][0] <= DofNyy) {
                    omm = otbl[i][1]
                    odd = DofNyy - otbl[i][0] + 1
                    break
                }
            }
        }
        if (omm < 0) {
            //			uruu = '閏';
            uruu = "閏"
            omm = -omm
        } else {
            //			uruu = '';
            uruu = ""
        }
        //	return Array(oyy,omm,odd,uruu);
    }

    // グレゴリウス暦閏年判定。閏年なら 1, 平年なら 0
    //function LeapYear(yy) {
    internal fun LeapYear(yy: Int): Int {
        //	var ans = 0;
        var ans = 0
        if (yy % 4 == 0) ans = 1
        if (yy % 100 == 0) ans = 0
        if (yy % 400 == 0) ans = 1
        return ans
    }

    // 新暦年初からの通日 1/1 = 1
    //function NumberDays(yy,mm,dd) {
    internal fun NumberDays(yy: Int, mm: Int, dd: Int): Int {
        nmdays[1] = 28 + LeapYear(yy)

        //		var days = dd;
        var days = dd
        //		for (var m = 1; m < mm ; m++) {
        for (m in 1 until mm) {
            days += nmdays[m - 1]
        }
        return days
    }

    // 旧暦・新暦テーブル(otbl)作成
    //function TblExpand(yy) {
    internal fun TblExpand(yy: Int) {
        //	var ommax,days,uruu,bit;
        val ommax: Int
        var days: Int
        val uruu: Int
        var bit: Int

        days = o2ntbl[yy - nyymin][0]
        bit = o2ntbl[yy - nyymin][1]
        uruu = days % 13    // 閏月抽出。無ければ 0
        //		days = Math.floor(days / 13 + 0.001);	// 旧暦年初の新暦年初からの日数
        days = Math.floor(days / 13 + 0.001).toInt()    // 旧暦年初の新暦年初からの日数

        //	otbl[0] = Array(days,1);	// 旧暦正月の通日と、月数
        otbl[0][0] = days
        otbl[0][1] = 1    // 旧暦正月の通日と、月数
        if (uruu == 0) {
            bit *= 2    // 閏無しなら 12ヶ月
            ommax = 12
        } else {
            ommax = 13
        }

        //	for (var i = 1; i <= ommax; i++) {
        for (i in 1..ommax) {
            //		otbl[i] = Array(otbl[i-1][0]+29, i+1);
            otbl[i][0] = otbl[i - 1][0] + 29
            otbl[i][1] = i + 1
            if (bit >= 4096) {
                otbl[i][0]++    // 大の月
            }
            bit = bit % 4096 * 2
        }
        otbl[ommax][1] = 0    // テーブルの終わり＆旧暦翌年年初

        if (ommax > 12) {// 閏月のある年
            //		for (var i = uruu + 1; i < 13 ; i++) {
            for (i in uruu + 1..12) {
                otbl[i][1] = i
            }
            otbl[uruu][1] = -uruu    // 識別のため閏月はマイナスで記録
        } else {
            //		otbl[13] = Array(0,0);	// 使ってないけどエラー防止で。
            otbl[13][0] = 0
            otbl[13][1] = 0    // 使ってないけどエラー防止で。
        }
    }

}