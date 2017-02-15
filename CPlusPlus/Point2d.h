/*
 * Point2d.h
 *
 *  Created on: Feb 4, 2017
 *      Author: Saurabh
 */
#include <cmath>
#include <iostream>

#ifndef POINT2D_H_
#define POINT2D_H_

namespace Quizes {

	class Point2d {
		private:
			double m_x;
			double m_y;
		public:
			Point2d(double x = 0, double y = 0);
			virtual ~Point2d();
			void print();
			double distanceTo (Point2d &other);
	};

} /* namespace Quizes */

#endif /* POINT2D_H_ */
